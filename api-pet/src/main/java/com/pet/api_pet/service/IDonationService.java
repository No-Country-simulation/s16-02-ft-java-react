package com.pet.api_pet.service;

import com.pet.api_pet.model.Donation;

import java.util.List;
import java.util.UUID;

public interface IDonationService extends ICRUDService<Donation,UUID>{

    //List<Donation> findAllDonationsByPerfilId(UUID id);
    //List<Donation>findAllDonationsByShelterId(UUID id);
}
