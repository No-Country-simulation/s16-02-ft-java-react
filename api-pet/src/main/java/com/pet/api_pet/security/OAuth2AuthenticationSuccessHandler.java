package com.pet.api_pet.security;

import com.pet.api_pet.config.AppProperties;
import com.pet.api_pet.model.Role;
import com.pet.api_pet.model.User;
import com.pet.api_pet.repository.IUserRepo;
import com.pet.api_pet.util.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenProvider tokenProvider;
    private final AppProperties appProperties;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    private final IUserRepo userRepo;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = tokenProvider.createToken(authentication);
        UserDetails user = (UserDetails) authentication.getPrincipal(); // obtener el usuario autentificado
        Optional<User> user1 = userRepo.findByUsername(user.getUsername());
        response.setContentType("application/json");
        response.getWriter().write("{\"token\":\"" + token + "\", \"user\": { \"userId\":\"" + user1.get().getUserId() + "\",\"email\":\"" + user.getUsername() + "\", \"rol\":\"" + user1.get().getRole().getRoleName() + "\"}}");
    }

  /*  protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Optional<String> redirectUri = CookieUtils
                .getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);

        if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new BadRequestException("Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication");
        }

        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());

        String token = tokenProvider.createToken(authentication);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("token", token)
                .build().toUriString();
    }
*/
  protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
      super.clearAuthenticationAttributes(request);
      httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
      CookieUtils.deleteCookie(request, response, null);
  }

    /*private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);

        return appProperties.getOAuth2().getAuthorizedRedirectUris()
                .stream()
                .anyMatch(authorizedRedirectUri -> {
                    // Only validate host and port. Let the clients use different paths if they want to
                    URI authorizedURI = URI.create(authorizedRedirectUri);
                    return authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                            && authorizedURI.getPort() == clientRedirectUri.getPort();
                });
    }*/
}
