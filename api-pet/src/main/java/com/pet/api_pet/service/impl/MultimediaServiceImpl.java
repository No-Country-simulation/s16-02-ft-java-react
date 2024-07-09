package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Multimedia;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IMultimediaRepo;
import com.pet.api_pet.service.IMultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MultimediaServiceImpl extends CRUDServiceImpl<Multimedia, UUID> implements IMultimediaService {

    @Autowired
    private IMultimediaRepo repo;

    @Override
    protected IGenericRepo<Multimedia, UUID> getRepo() {
        return repo;
    }
}
