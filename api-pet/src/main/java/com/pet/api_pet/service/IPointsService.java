package com.pet.api_pet.service;

import com.pet.api_pet.model.Points;

import java.util.UUID;

public interface IPointsService extends ICRUDService<Points, UUID> {
    Points findPointsByProfileId(UUID id);

}
