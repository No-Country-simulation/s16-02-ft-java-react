package com.pet.api_pet.repository;

import com.pet.api_pet.model.Pet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IPetRepo extends IGenericRepo<Pet, UUID>, JpaSpecificationExecutor<Pet> {

    @Query(value = "SELECT p.active, p.pet_age, p.pet_weight, p.created_at, p.deleted_at, p.district_id, p.updated_at, p.created_by, p.deleted_by, p.pet_id, p.shelter_id, p.updated_by, p.pet_breed, p.pet_name, p.pet_found_place, p.pet_temperament, p.pet_sex, p.pet_size, p.pet_state, p.pet_type\n" +
            "\tFROM pets p WHERE shelter_id=:shelterId",nativeQuery = true)
    List<Pet>findAllPetsByShelterId(@PathVariable("shelterId") UUID shelterId);
    //List<Pet>findAllPetsByAdoptionId(UUID id);
}
