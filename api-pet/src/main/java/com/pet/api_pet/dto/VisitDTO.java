package com.pet.api_pet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitDTO {

    private UUID visitId;

    private LocalDate visitDate;

    private LocalTime visitHour;

    private String visitReason;

    private UserDTO user;

    private ShelterDTO shelter;
}
