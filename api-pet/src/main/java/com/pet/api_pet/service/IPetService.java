package com.pet.api_pet.service;

import com.pet.api_pet.model.Pet;

import java.util.List;
import java.util.UUID;

public interface IPetService extends ICRUDService<Pet,UUID>{
    List<Pet> findAllPetsByShelterId(UUID id);
    List<Pet>findAllPetsByAdoptionId(UUID id);
}
