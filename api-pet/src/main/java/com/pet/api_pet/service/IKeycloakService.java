package com.pet.api_pet.service;

import com.pet.api_pet.dto.User1DTO;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakService {

    List<UserRepresentation> findAllUsers();
    List<UserRepresentation> searchUserByUsername(String username);
    String createUser(User1DTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, User1DTO userDTO);
}