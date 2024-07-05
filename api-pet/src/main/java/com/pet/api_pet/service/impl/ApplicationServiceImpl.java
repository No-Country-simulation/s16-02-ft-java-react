package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Application;
import com.pet.api_pet.repository.IApplicationRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationServiceImpl extends CRUDServiceImpl<Application, UUID> implements IApplicationService {

    @Autowired
    private IApplicationRepo repo;

    @Override
    protected IGenericRepo<Application, UUID> getRepo() {
        return repo;
    }
}
