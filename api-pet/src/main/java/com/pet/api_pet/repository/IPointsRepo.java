package com.pet.api_pet.repository;

import com.pet.api_pet.model.adoption.Points;

import java.util.UUID;

public interface IPointsRepo extends IGenericRepo<Points, UUID> {

    //Points findPointsByProfileId(UUID id);
}
