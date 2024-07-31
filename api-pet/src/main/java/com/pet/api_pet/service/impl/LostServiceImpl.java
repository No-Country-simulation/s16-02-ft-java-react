package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.adoption.Lost;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.ILostRepository;
import com.pet.api_pet.service.ILostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LostServiceImpl extends CRUDServiceImpl<Lost, UUID> implements ILostService {

    @Autowired
    private ILostRepository repo;

    @Override
    protected IGenericRepo<Lost, UUID> getRepo() {
        return repo;
    }
}
