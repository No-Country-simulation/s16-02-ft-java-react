package com.pet.api_pet.service;

import com.pet.api_pet.dto.ProfileDTO;
import com.pet.api_pet.model.Profile;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface IProfileService extends ICRUDService<Profile, UUID> {
    Profile findByUserId(UUID id);
}
