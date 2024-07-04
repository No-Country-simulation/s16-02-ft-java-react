package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Profile;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IProfileRepo;
import com.pet.api_pet.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileServiceImpl extends CRUDServiceImpl<Profile, UUID> implements IProfileService {

    @Autowired
    private IProfileRepo repo;

    @Override
    protected IGenericRepo<Profile, UUID> getRepo() {
        return repo;
    }

    @Override
    public Profile findByUserId(UUID id) {
        return repo.findByUserId(id);
    }
}
