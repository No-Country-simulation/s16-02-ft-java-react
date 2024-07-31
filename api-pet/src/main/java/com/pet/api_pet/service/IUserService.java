package com.pet.api_pet.service;

import com.pet.api_pet.model.auth.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserService extends ICRUDService<User, UUID> {
    Optional<User> findByUsername(String username);

}
