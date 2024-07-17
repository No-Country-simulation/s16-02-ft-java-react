package com.pet.api_pet.security;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.pet.api_pet.security.filter.CustomAuthorizationCodeGrantRequestEntityConverter;
import com.pet.api_pet.security.filter.JwtAuthenticationFilter;
import com.pet.api_pet.security.filter.JwtValidationFilter;
import com.pet.api_pet.service.impl.GoogleOAuth2UserService;
import com.pet.api_pet.service.impl.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity( prePostEnabled = true)
public class SpringSecurityConfig {


    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private GoogleOAuth2UserService googleOAuth2UserService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/health").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/users").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/profiles").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/login").permitAll()
                        //.requestMatchers(HttpMethod.GET, "/api/auth/google/login").permitAll()
                        .requestMatchers("/","api/login/**","api/auth/oauth2/**").permitAll()

                        .anyRequest().authenticated())
                .addFilter(jwtAuthorizationFilter())
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationManager()))
                .userDetailsService(userDetailsService)
                //.httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .oauth2Login(oauth2Login -> oauth2Login
                        //.loginPage("/api/auth/oauth2/google")
                        .defaultSuccessUrl("/api/auth/oauth2/success", true)
                        .failureUrl("/api/auth/failure")
                        /*.tokenEndpoint(tokenEndpoint -> tokenEndpoint
                                .accessTokenResponseClient())*/
                                .userInfoEndpoint(userInfo -> userInfo
                                .oidcUserService(googleOAuth2UserService)))
                .build();
    }

    @Bean
    public DefaultAuthorizationCodeTokenResponseClient authorizationCodeTokenResponseClient() {
        DefaultAuthorizationCodeTokenResponseClient tokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
        tokenResponseClient.setRequestEntityConverter(new CustomAuthorizationCodeGrantRequestEntityConverter());
        return tokenResponseClient;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(Boolean.TRUE);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","https://frontend-docspot-rnzn.vercel.app"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setMaxAge(Duration.ofDays(3600L)); // 1 hour

        // Add CSRF protection
        configuration.setExposedHeaders(List.of("X-CSRF-TOKEN"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public JwtAuthenticationFilter jwtAuthorizationFilter() throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/login");
        return jwtAuthenticationFilter;
    }



}