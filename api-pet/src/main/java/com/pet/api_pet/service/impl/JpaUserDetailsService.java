package com.pet.api_pet.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.pet.api_pet.model.User;
import com.pet.api_pet.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepo repository;

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

}
