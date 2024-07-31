package com.pet.api_pet.model.adoption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.api_pet.model.*;
import com.pet.api_pet.model.auth.User;
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
@Table(name = "shelters")
public class Shelter extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shelter_id")
    private UUID shelterId=UUID.randomUUID();

    private String shelterName;

    private String shelterAuthorization;

    private String shelterImgAuthorization;

    private String shelterAddress;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_SHELTERS_USER"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false,foreignKey = @ForeignKey(name = "FK_SHELTERS_DISTRICT"))
    private District district;

    @OneToMany(mappedBy = "shelter",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    List<Pet>pets;

    @OneToMany(mappedBy = "shelter",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Donation>donations;

    @OneToMany(mappedBy = "shelter",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Visit>visits;
}
