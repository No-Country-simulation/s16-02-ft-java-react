package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Visit;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IVisitRepo;
import com.pet.api_pet.service.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VisitServiceImpl extends CRUDServiceImpl<Visit, UUID> implements IVisitService {

    @Autowired
    private IVisitRepo repo;


    @Override
    protected IGenericRepo<Visit, UUID> getRepo() {
        return repo;
    }
}
