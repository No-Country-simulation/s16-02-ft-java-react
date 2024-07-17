package com.pet.api_pet.controllers;


import com.pet.api_pet.dto.GoogleDTO;
import com.pet.api_pet.dto.RegisterDTO;
import com.pet.api_pet.dto.RoleDTO;
import com.pet.api_pet.dto.UserDTO;
import com.pet.api_pet.model.Role;
import com.pet.api_pet.model.User;
import com.pet.api_pet.repository.IRoleRepo;
import com.pet.api_pet.service.impl.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JpaUserDetailsService userService;

    @Autowired
    private IRoleRepo repo;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterDTO user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/oauth2/google")
    public String loginWithGoogle() {
        return "redirect:/oauth2/authorization/google";
    }
    @GetMapping("/oauth2/success")
    public ResponseEntity<GoogleDTO> loginSuccess(OAuth2AuthenticationToken authentication) {
        try {
            OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                    authentication.getAuthorizedClientRegistrationId(),
                    authentication.getName());

            String accessToken = client.getAccessToken().getTokenValue();
            String refreshToken = client.getRefreshToken().getTokenValue();

            UserDTO user = new UserDTO();
            user.setUsername(authentication.getPrincipal().getAttribute("email"));
            user.setActive(true);

            Role role = repo.findRoleByName("ROLE_USER");
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleName(role.getRoleName());
            roleDTO.setRoleId(role.getRoleId());
            user.setRole(roleDTO);

            GoogleDTO google = new GoogleDTO();
            google.setUser(user);
            google.setToken(accessToken);
            google.setRefreshToken(refreshToken);

            return ResponseEntity.ok(google);
        } catch (Exception e) {
            // Manejo de excepciones detallado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/failure")
    public String loginFailure() {
        return "Login Failed";
    }
}
