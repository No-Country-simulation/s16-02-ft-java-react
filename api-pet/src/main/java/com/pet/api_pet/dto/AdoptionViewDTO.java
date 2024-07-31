package com.pet.api_pet.dto;

import java.time.Instant;
import java.util.UUID;

public record AdoptionViewDTO(UUID adoptionId,Instant adoptionDate,String profileName,String profileLastName,UUID petId,String petName,UUID shelterId,String shelterName,UUID userId) {
}
