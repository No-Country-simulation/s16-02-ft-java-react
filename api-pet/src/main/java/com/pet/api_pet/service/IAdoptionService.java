package com.pet.api_pet.service;

import com.pet.api_pet.model.adoption.Adoption;
import com.pet.api_pet.model.adoption.AdoptionView;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IAdoptionService extends ICRUDService<Adoption,UUID>{
    List<AdoptionView> findAllAdoptionByUserId(@PathVariable("id") UUID id);

}
