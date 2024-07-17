package com.pet.api_pet.security.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequestEntityConverter;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomAuthorizationCodeGrantRequestEntityConverter extends OAuth2AuthorizationCodeGrantRequestEntityConverter {
/*
    @Override
    public RequestEntity<?> convert(OAuth2AuthorizationCodeGrantRequest authorizationCodeGrantRequest) {
        //RequestEntity<?> requestEntity = super.convert(authorizationCodeGrantRequest);

        if (requestEntity == null) {
            throw new IllegalArgumentException("RequestEntity is null");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Cambia a application/json
       // headers.setContentType(requestEntity.getHeaders().getContentType());
       // headers.setAccept(Collections.singletonList(requestEntity.getHeaders().getAccept().get(0)));

        // Initialize the body as a new LinkedHashMap if it is null
        Map<String, Object> body = new LinkedHashMap<>();
        if (requestEntity.getBody() instanceof Map) {
            body.putAll((Map<String, Object>) requestEntity.getBody());
        }


        // Modify body as needed
        // Add required parameters
        // Crear un nuevo mapa para el cuerpo
        Map<String, Object> body = new HashMap<>();
        body.put("code", authorizationCodeGrantRequest.getAuthorizationExchange().getAuthorizationResponse().getCode());
        body.put("client_id", authorizationCodeGrantRequest.getClientRegistration().getClientId());
        body.put("client_secret", authorizationCodeGrantRequest.getClientRegistration().getClientSecret());
        body.put("redirect_uri", authorizationCodeGrantRequest.getAuthorizationExchange().getAuthorizationRequest().getRedirectUri());
        body.put("grant_type", authorizationCodeGrantRequest.getGrantType().getValue());
        //body.put("access_type", "offline");

        // Construct and return a new RequestEntity
        return new RequestEntity<>(
                //buildFormData(body),
                body,
                headers,
                HttpMethod.POST,
                URI.create(authorizationCodeGrantRequest.getClientRegistration().getProviderDetails().getTokenUri())
        );
    }

    private static String buildFormData(Map<String, ?> data) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, ?> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append('&');
            }
            builder.append(encode(entry.getKey()));
            builder.append('=');
            builder.append(encode(entry.getValue().toString()));
        }
        return builder.toString();
    }

    private static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Failed to encode URI parameter", ex);
        }
    }*/

    @Override
    public RequestEntity<?> convert(OAuth2AuthorizationCodeGrantRequest authorizationCodeGrantRequest) {
        RequestEntity<?> requestEntity = super.convert(authorizationCodeGrantRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(requestEntity.getHeaders().getContentType());
        headers.set(HttpHeaders.ACCEPT, "application/json");

        // Convert the body to a Map
        Map<String, Object> body = (Map<String, Object>) requestEntity.getBody();
        if (body == null) {
            body = new HashMap<>();
        }

        // Create a new map to avoid modification of the original request body
        Map<String, Object> requestBody = new HashMap<>(body);
        requestBody.put("access_type", "offline");

        return new RequestEntity<>(
                requestBody,
                headers,
                HttpMethod.POST,
                URI.create(requestEntity.getUrl().toString())
        );
    }
}

