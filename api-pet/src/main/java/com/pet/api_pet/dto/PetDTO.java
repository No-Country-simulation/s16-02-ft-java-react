package com.pet.api_pet.dto;

import com.pet.api_pet.model.*;
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
public class PetDTO {

    private UUID petId;

    private String petName;

    private Integer petAge;

    @Enumerated(EnumType.STRING)
    private PetType petType;//1: Cat, 2: Dog

    private String petBreed;

    @Enumerated(EnumType.STRING)
    private PetSize petSize; //1: Toy,2: Little,3:Medium,4:Large,5:Giant

    @Enumerated(EnumType.STRING)
    private PetSex petSex; // 1: Male, 2: Female

    private Double petWeight;

    @Enumerated(EnumType.STRING)
    private PetState petState; //1: Lost, 2:Rescued

    private String petTemperament;

    private String petFoundPlace;

    private District district;

    private Shelter shelter;
}
