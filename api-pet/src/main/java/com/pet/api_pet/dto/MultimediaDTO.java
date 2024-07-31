package com.pet.api_pet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaDTO {

    private UUID multimediaId;

    private String urlMultimedia;

    private Boolean principal;
    //private PetDTO pet;
}
