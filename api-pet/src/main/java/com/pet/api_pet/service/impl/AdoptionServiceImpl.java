package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Adoption;
import com.pet.api_pet.repository.IAdoptionRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.IAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class AdoptionServiceImpl extends CRUDServiceImpl<Adoption, UUID> implements IAdoptionService {

    @Autowired
    private IAdoptionRepo repo;


    @Override
    protected IGenericRepo<Adoption, UUID> getRepo() {
        return repo;
    }
}
