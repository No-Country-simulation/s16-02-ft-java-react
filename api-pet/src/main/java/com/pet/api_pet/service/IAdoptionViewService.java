package com.pet.api_pet.service;

import com.pet.api_pet.model.adoption.AdoptionView;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IAdoptionViewService extends ICRUDService<AdoptionView, UUID> {
    List<AdoptionView> findAllAdoptionByUserId(@PathVariable("id") UUID id);

}
