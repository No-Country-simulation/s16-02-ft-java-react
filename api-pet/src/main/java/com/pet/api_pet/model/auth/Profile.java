package com.pet.api_pet.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.api_pet.model.*;
import com.pet.api_pet.model.adoption.Donation;
import com.pet.api_pet.model.adoption.Points;
import com.pet.api_pet.model.adoption.Visit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "profile_id")
    private UUID profileId=UUID.randomUUID();

    @Column(name = "profile_name",nullable = false,length = 70)
    private String profileName;

    @Column(name = "profile_last_name",nullable = false,length = 120)
    private String profileLastName;

    @Column(name = "profile_phone",nullable = false,length = 14)
    private String profilePhone;

    @Column(name = "profile_document_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType profileDocumentType;//1: dni,2:carnet de extrangeria,3:pasaporte

    @Column(name = "profile_document_number",nullable = false,length = 13)
    private String profileDocumentNumber;

    @Column(name = "profile_img_document",nullable = false)
    private String profileImgDocument;

    @Column(name = "profile_address",nullable = false)
    private String profileAddress;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PROFILES_USER"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PROFILES_DISTRICT"))
    private District district;

    @OneToMany(mappedBy = "profile",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Points>points;

    @OneToMany(mappedBy = "profile",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Donation>donations;
}
