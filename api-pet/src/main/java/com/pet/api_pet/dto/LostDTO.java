package com.pet.api_pet.dto;

import com.pet.api_pet.model.Pet;
import com.pet.api_pet.model.User;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
