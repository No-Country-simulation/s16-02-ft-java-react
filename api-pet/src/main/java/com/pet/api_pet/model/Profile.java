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
@Table(name = "profiles")
public class Profile extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "profile_id")
    private UUID profileId=UUID.randomUUID();

    private String profileName;

    private String profileLastName;

    private String profilePhone;

    private Integer profileDocumentType;

    private String profileDocumentNumber;

    private String profileImgDocument;

    private String profileAddress;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PROFILES_DISTRICT"))
    private District district;
}
