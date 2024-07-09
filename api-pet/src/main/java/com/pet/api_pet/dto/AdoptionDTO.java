package com.pet.api_pet.dto;

import com.pet.api_pet.model.Auditable;

import java.time.Instant;
import java.util.UUID;


public class AdoptionDTO extends Auditable {

    private UUID adoptionId;

    private Instant adoptionDate;

    private ApplicationDTO application;
}
