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

    private String petName;

    private Integer petAge;

    private Integer petType;//1: Dog, 2: Cat

    private String petBreed;

    private Integer petSize; //1: Toy,2: Pequeño,3:Mediano,4:Grande,5:Gigante

    private Boolean petSex; // True: macho, False: hembra

    private Double petWeight;

    private String petStatus;

    private String petBehavior;

    @ManyToOne
    @JoinColumn(name = "shelter_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PETS_SHELTER"))
    private Shelter shelter;
}
