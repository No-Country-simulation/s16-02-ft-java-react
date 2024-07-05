package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Shelter;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IShelterRepo;
import com.pet.api_pet.service.IShelterService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;


public class ShelterServiceImp extends CRUDServiceImpl<Shelter, UUID> implements IShelterService{

    @Autowired
    IShelterRepo repo;
    
    @Override
    protected IGenericRepo<Shelter, UUID> getRepo() {
        return repo;
    }

    @Override
    public Shelter findByUserId(UUID id) {
      return repo.findByUserId(id);
    }

}
