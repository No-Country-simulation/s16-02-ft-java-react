package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Pet;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IPetRepo;
import com.pet.api_pet.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PetServiceImpl extends CRUDServiceImpl<Pet, UUID> implements IPetService {

    @Autowired
    private IPetRepo repo;

    @Override
    protected IGenericRepo<Pet, UUID> getRepo() {
        return repo;
    }
}
