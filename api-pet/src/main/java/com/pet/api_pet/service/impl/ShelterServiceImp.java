package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.adoption.Shelter;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IShelterRepo;
import com.pet.api_pet.service.IShelterService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceImp extends CRUDServiceImpl<Shelter, UUID> implements IShelterService{

    @Autowired
    private IShelterRepo repo;
    
    @Override
    protected IGenericRepo<Shelter, UUID> getRepo() {
        return repo;
    }

    @Override
    public Shelter findByUserId(UUID id) {
      return repo.findByUserId(id);
    }

}
