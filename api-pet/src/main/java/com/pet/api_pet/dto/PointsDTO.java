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
public class PointsDTO {

    private UUID pointId;

    private Long pointNumber;

    private ProfileDTO profile;
}
