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
public class VisitDTO {

    private UUID visitId;

    private String visitDate;

    private String visitHour;

    private String visitReason;

    private UserDTO user;
}
