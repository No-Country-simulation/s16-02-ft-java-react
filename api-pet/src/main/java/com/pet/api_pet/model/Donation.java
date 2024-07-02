package com.pet.api_pet.model;

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
@Entity
@Table(name = "donations")
public class Donation extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "donation_id")
    private UUID donationId=UUID.randomUUID();

    private Double donationAmount;

    private Integer donationMoneyType; //1:Dolares,2:Pesos Argentinos, 3:Soles, 4:Pesos Bolivianos,5:Pesos Chilenos,etc

    private Instant donationDate;

    @ManyToOne
    @JoinColumn(name = "profile_id",nullable = false,foreignKey = @ForeignKey(name = "FK_DONATIONS_PROFILE"))
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "shelter_id",nullable = false,foreignKey = @ForeignKey(name = "FK_DONATIONS_SHELTER"))
    private Shelter shelter;
}
