package com.pet.api_pet.controllers;


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
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JpaUserDetailsService userService;

    @Autowired
    private IRoleRepo repo;

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

    @GetMapping("/login/oauth2/success")
    public User loginSuccess(OAuth2AuthenticationToken authentication) {
        // Aquí puedes manejar la lógica después del login exitoso
        User user = new User();
        user.setUsername(authentication.getPrincipal().getAttribute("email"));
        user.setActive(true);
        Role role = new Role();
        role = repo.findRoleByName("ROLE_USER");
        user.setRole(role);
        return user;
    }

    @GetMapping("/failure")
    public String loginFailure() {
        return "Login Failed";
    }
}
