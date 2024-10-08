package com.pet.api_pet.service;

import com.pet.api_pet.model.auth.Profile;

import java.util.UUID;

public interface IProfileService extends ICRUDService<Profile, UUID> {
    Profile findByUserId(UUID id);
}
