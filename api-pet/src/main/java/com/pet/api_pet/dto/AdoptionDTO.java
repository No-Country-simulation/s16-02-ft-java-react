package com.pet.api_pet.dto;

import com.pet.api_pet.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionDTO extends Auditable {

    private UUID adoptionId;

    private Instant adoptionDate;

    private ApplicationDTO application;
}
