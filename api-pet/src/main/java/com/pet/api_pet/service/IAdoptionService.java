package com.pet.api_pet.service;

import com.pet.api_pet.model.Adoption;
import com.pet.api_pet.model.AdoptionView;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IAdoptionService extends ICRUDService<Adoption,UUID>{
    List<AdoptionView> findAllAdoptionByUserId(@PathVariable("id") UUID id);

}
