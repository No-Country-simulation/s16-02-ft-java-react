package com.pet.api_pet.dto;

import com.pet.api_pet.model.Application;

import java.time.Instant;
import java.util.UUID;

public class AdoptionDTO {

    private UUID adoptionId;

    private Instant adoptionDate;

    private ApplicationDTO application;
}
