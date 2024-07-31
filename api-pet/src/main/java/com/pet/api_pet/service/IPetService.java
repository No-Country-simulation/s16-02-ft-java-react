package com.pet.api_pet.service;

import com.pet.api_pet.model.adoption.Multimedia;
import com.pet.api_pet.model.adoption.Pet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IPetService extends ICRUDService<Pet,UUID>{

    //List<Pet>findAllPetsByAdoptionId(UUID id);

    Page<Pet> getFilteredPets(String petName, String petSex,String petBreed,String petSize,String petType ,Integer minAge, Integer maxAge, int page, int size);
    List<Pet> findAllPetsByShelterId(UUID shelterId);
    Pet saveTransactional(Pet pet, List<Multimedia>listMultimedia);
    List<Pet>getAllPets();
}
