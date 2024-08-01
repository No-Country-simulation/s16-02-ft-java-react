package com.pet.api_pet.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

/*public record AdoptionViewDTO(UUID adoptionId,Instant adoptionDate,String profileName,String profileLastName,UUID petId,String petName,UUID shelterId,String shelterName,UUID userId) {
}*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionViewDTO{
    private UUID adoptionId;

    private Instant adoptionDate;

    private UUID applicationId;

    private String profileName;

    private String profileLastName;

    private UUID petId;

    private String petName;

    private UUID shelterId;

    private String shelterName;

    private UUID userId;
}
