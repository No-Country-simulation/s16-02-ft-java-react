package com.pet.api_pet.model;

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
@Entity
@Table(name = "shelters")
public class Shelter extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shelter_id")
    private UUID shelterId=UUID.randomUUID();

    private String shelterName;

    private String shelterAuthorization;

    private String shelterImgAuthorization;

    private String shelterAddress;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false,foreignKey = @ForeignKey(name = "FK_SHELTERS_DISTRICT"))
    private District district;

}
