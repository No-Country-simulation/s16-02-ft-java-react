package com.pet.api_pet.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.pet.api_pet.dto.RegisterDTO;
import com.pet.api_pet.model.Role;
import com.pet.api_pet.model.User;
import com.pet.api_pet.repository.IRoleRepo;
import com.pet.api_pet.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepo repository;

    @Autowired
    private IRoleRepo roleRepo;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = repository.findByUsername(username);
        System.out.println(userOptional);


        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema!", username));
        }

        User user = userOptional.orElseThrow();


        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().getRoleName())
        );


        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.getActive(),
                true,
                true,
                true,
                authorities);
    }

    public User registerUser(RegisterDTO userDto) {
        // Validar que el usuario no exista previamente
        if (repository.findByUsername(userDto.getUsername()).isPresent()) {
            System.out.println("Usuario: "+repository.findByUsername(userDto.getUsername()));
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        // Encriptar la contraseña del usuario
        String encryptedPassword = encryptPassword(userDto.getPassword());
        // Set information in User entity
        user.setUsername(userDto.getUsername());
        user.setActive(true);

        user.setPassword(encryptedPassword);
        //Asignación del rol
        Role role = roleRepo.findRoleByName(userDto.getRoleName());
        user.setRole(role);
        // Guardar el usuario en la base de datos
        return repository.save(user);
    }

    private String encryptPassword(String password) {
        // Implementar la lógica de encriptación de contraseña aquí
        // Por ejemplo, utilizando BCrypt
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

}
