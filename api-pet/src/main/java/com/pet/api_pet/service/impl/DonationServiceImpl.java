package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.adoption.Donation;
import com.pet.api_pet.repository.IDonationRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DonationServiceImpl extends CRUDServiceImpl<Donation, UUID> implements IDonationService {

    @Autowired
    private IDonationRepo repo;

    @Override
    protected IGenericRepo<Donation, UUID> getRepo() {
        return repo;
    }
}
