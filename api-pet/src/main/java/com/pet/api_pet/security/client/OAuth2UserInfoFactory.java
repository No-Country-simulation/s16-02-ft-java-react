package com.pet.api_pet.security.client;

import com.pet.api_pet.exception.OAuth2AuthenticationProcessingException;
import com.pet.api_pet.model.enums.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.linkedin.toString())) {
            return new LinkedinOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.twitter.toString())) {
            return new TwitterOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException(String.format("Login with %s is not supported.", registrationId));
        }
    }

}
