package com.pet.api_pet.dto;

import com.pet.api_pet.model.adoption.MoneyType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationDTO {

    private UUID donationId;

    private Double donationAmount;

    @Enumerated(EnumType.STRING)
    private MoneyType donationMoneyType; //1:Dolares,2:Pesos Argentinos, 3:Soles, 4:Pesos Bolivianos,5:Pesos Chilenos,6: PesosDominicanos

    private Instant donationDate;

    private ProfileDTO profile;

    private ShelterDTO shelter;
}
