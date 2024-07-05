package com.pet.api_pet.service;

import com.pet.api_pet.model.Pet;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IPetService extends ICRUDService<Pet,UUID>{

   /* @Query(value = "SELECT p.pet_id,p.pet_name,p.pet_age,pet_ FROM pets p WHERE  ")
    List<Pet> findAllPetsByShelterId(UUID id);*/
    //List<Pet>findAllPetsByAdoptionId(UUID id);
}
