package com.pet.api_pet.security;

import com.pet.api_pet.model.Role;
import com.pet.api_pet.model.User;
import com.pet.api_pet.model.enums.AuthProvider;
import com.pet.api_pet.repository.IRoleRepo;
import com.pet.api_pet.repository.IUserRepo;
import com.pet.api_pet.security.client.GoogleOAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final IUserRepo userRepository;
    private final IRoleRepo roleRepo;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo(oAuth2User.getAttributes());

        Optional<User> existingUser = userRepository.findByUsername(userInfo.getEmail());

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            //user.setAuthProvider(AuthProvider.google);
            //userRepository.save(user);
            //user.setActive(true);
            return UserPrincipal.create(user, oAuth2User.getAttributes());
        } else {
            User newUser = new User();
            Role role = new Role();
            newUser.setUsername(userInfo.getEmail());
            newUser.setFirstName(userInfo.getName());
            //newUser.setLastname(null);
            newUser.setPassword(null);
            newUser.setAuthProvider(AuthProvider.google);
            newUser.setActive(true);
            role=roleRepo.findRoleByName("ROLE_USER");
            newUser.setRole(role);
            if (userRepository.findByUsername(newUser.getUsername()).isEmpty()) {
                userRepository.save(newUser);
            } else {
                //throw new UserExistsException("User with this email already exists.");
                return null;
            }

            return UserPrincipal.create(newUser, oAuth2User.getAttributes());
        }
    }
}
