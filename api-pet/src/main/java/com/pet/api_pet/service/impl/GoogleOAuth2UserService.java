package com.pet.api_pet.service.impl;


import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class GoogleOAuth2UserService extends OidcUserService {

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        // Aquí puedes agregar lógica adicional, como guardar el usuario en la base de datos si es necesario
        System.out.println("oidecUser: "+oidcUser);
        return oidcUser;
    }
}