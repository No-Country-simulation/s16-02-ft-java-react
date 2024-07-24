package com.pet.api_pet.security;

import lombok.extern.slf4j.Slf4j;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pet.api_pet.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenProvider {

    private final AppProperties appProperties;
    private Algorithm ALGORITHM;

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        ALGORITHM = Algorithm.HMAC256(appProperties.getAuth().getTokenSecret());

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return JWT.create()
                .withSubject(userPrincipal.getId().toString())
                .withIssuedAt(now)
                .withExpiresAt(expirationDate)
                .sign(ALGORITHM);
    }

    public UUID getUserIdFromToken(String token) {
        JWTVerifier verifier = JWT.require(ALGORITHM).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String subject = decodedJWT.getSubject();
        return UUID.fromString(subject);
    }

    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error("Invalid or expired JWT.");
        }
        return false;
    }

}