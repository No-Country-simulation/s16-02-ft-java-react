package com.pet.api_pet.service;

import com.pet.api_pet.model.adoption.Shelter;

import java.util.UUID;

public interface IShelterService extends ICRUDService<Shelter, UUID> {
    Shelter findByUserId(UUID id);
}
