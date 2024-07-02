package com.pet.api_pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pets")
public class Pet extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pet_id")
    private UUID petId=UUID.randomUUID();

    @Column(name = "pet_name",nullable = false,length = 52)
    private String petName;

    @Column(name = "pet_age",nullable = false,length = 2)
    private Integer petAge;

    @Column(name = "pet_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private PetType petType;//1: Cat, 2: Dog

    @Column(name = "pet_breed",nullable = false,length = 50)
    private String petBreed;

    @Column(name = "pet_size",nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSize petSize; //1: Toy,2: Little,3:Medium,4:Large,5:Giant

    @Column(name = "pet_sex",nullable = false)
    @Enumerated(EnumType.STRING)
    private PetSex petSex; // 1: Male, 2: Female

    @Column(name = "pet_weight",nullable = false,length = 5)
    private Double petWeight;

    @Column(name = "pet_state",nullable = false)
    @Enumerated(EnumType.STRING)
    private PetState petState; //1: Lost, 2:Rescued

    @Column(name = "pet_temperament",nullable = false,length = 210)
    private String petTemperament;

    @Column(name = "pet_found_place",nullable = false,length = 210)
    private String petFoundPlace;

    @ManyToOne
    @JoinColumn(name = "district_id",foreignKey = @ForeignKey(name = "FK_PETS_DISTRICT"))
    private District district;

    @ManyToOne
    @JoinColumn(name = "shelter_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PETS_SHELTER"))
    private Shelter shelter;

    @OneToMany(mappedBy = "pet",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Application>applications;

    @OneToMany(mappedBy = "pet",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Multimedia>multimedia;

}
