package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Adoption;
import com.pet.api_pet.model.AdoptionView;
import com.pet.api_pet.repository.IAdoptionRepo;
import com.pet.api_pet.repository.IAdoptionViewRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.IAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class AdoptionServiceImpl extends CRUDServiceImpl<Adoption, UUID> implements IAdoptionService {

    @Autowired
    private IAdoptionRepo repo;

    @Autowired
    IAdoptionViewRepo viewRepo;

    @Override
    protected IGenericRepo<Adoption, UUID> getRepo() {
        return repo;
    }

    @Override
    public List<AdoptionView> findAllAdoptionByUserId(UUID id) {
        return viewRepo.findAllAdoptionByUserId(id);
    }
}
