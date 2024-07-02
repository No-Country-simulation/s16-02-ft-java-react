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

    @Column(name = "pet_type",nullable = false,length = 1)
    private Integer petType;//1: Dog, 2: Cat

    @Column(name = "pet_breed",nullable = false,length = 50)
    private String petBreed;

    @Column(name = "pet_size",nullable = false,length = 1)
    private Integer petSize; //1: Toy,2: Pequeño,3:Mediano,4:Grande,5:Gigante

    @Column(name = "pet_sex",nullable = false)
    private Boolean petSex; // True: macho, False: hembra

    @Column(name = "pet_weight",nullable = false,length = 5)
    private Double petWeight;

    @Column(name = "pet_status",nullable = false,length = 180)
    private String petStatus;

    @Column(name = "pet_behavior",nullable = false,length = 210)
    private String petBehavior;

    @ManyToOne
    @JoinColumn(name = "shelter_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PETS_SHELTER"))
    private Shelter shelter;
}
