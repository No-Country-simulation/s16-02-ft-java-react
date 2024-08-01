package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.adoption.AdoptionView;
import com.pet.api_pet.repository.IAdoptionViewRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.IAdoptionViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdoptionViewServiceImpl extends CRUDServiceImpl<AdoptionView, UUID> implements IAdoptionViewService {

    @Autowired
    private IAdoptionViewRepo repo;

    @Override
    public List<AdoptionView> findAllAdoptionByUserId(UUID id) {

        return repo.findAllAdoptionByUserId(id);
    }
    @Override
    protected IGenericRepo<AdoptionView, UUID> getRepo() {
        return repo;
    }
}
