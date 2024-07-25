package com.pet.api_pet.dto;

import com.pet.api_pet.model.adoption.ApplicationState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO{
    private UUID applicationId;

    private String applicationNumber;//Código de solicitud de adopción Ejmpl: 0001-00000123;

    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    private ProfileDTO profile;

    private PetDTO pet;
}
