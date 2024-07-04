package com.pet.api_pet.repository;

import com.pet.api_pet.model.Pet;

import java.util.List;
import java.util.UUID;

public interface IPetRepo extends IGenericRepo<Pet, UUID> {

    //List<Pet>findAllPetsByShelterId(UUID id);
    //List<Pet>findAllPetsByAdoptionId(UUID id);
}