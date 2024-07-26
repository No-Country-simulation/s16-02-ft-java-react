package com.pet.api_pet.controllers;


import com.pet.api_pet.dto.RegisterDTO;
import com.pet.api_pet.dto.UserDTO;
import com.pet.api_pet.model.auth.User;
import com.pet.api_pet.service.impl.JpaUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService service;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private JpaUserDetailsService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterDTO user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserDTO> findUser(@PathVariable("username") String username) {
        Optional<User> userOptional = service.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userDTO = mapper.map(user, UserDTO.class);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
