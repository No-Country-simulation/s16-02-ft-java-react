package com.pet.api_pet.service;

import com.pet.api_pet.model.Pet;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IPetService extends ICRUDService<Pet,UUID>{

   /* @Query(value = "SELECT p.pet_id,p.pet_name,p.pet_age,pet_ FROM pets p WHERE  ")
    List<Pet> findAllPetsByShelterId(UUID id);*/
    //List<Pet>findAllPetsByAdoptionId(UUID id);

    Page<Pet> getFilteredPets(String petName, String petSex,String petBreed,String petSize,String petType ,Integer minAge, Integer maxAge, int page, int size);

}
