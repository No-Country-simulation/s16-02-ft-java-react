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
public class LostDTO {

    private UUID lostId;

    private String latX;

    private String latY;

    private String lostDescription;

    private String lostReference;

    private String lostAddress;

    private PetDTO pet;

    private UserDTO user;
}
