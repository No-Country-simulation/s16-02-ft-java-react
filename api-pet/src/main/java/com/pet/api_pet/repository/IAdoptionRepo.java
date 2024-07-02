package com.pet.api_pet.repository;

import com.pet.api_pet.model.Adoption;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IAdoptionRepo extends IGenericRepo<Adoption, UUID> {

    //List<Adoption> findAllAdoptionByProfileId(UUID id);
    //Adoption findAdoptionByProfileId(UUID id);

}
