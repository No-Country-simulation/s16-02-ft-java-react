package com.pet.api_pet.repository;

import com.pet.api_pet.model.adoption.Donation;

import java.util.UUID;

public interface IDonationRepo extends IGenericRepo<Donation, UUID>{

    //List<Donation>findAllDonationsByPerfilId(UUID id);
    //List<Donation>findAllDonationsByShelterId(UUID id);
}
