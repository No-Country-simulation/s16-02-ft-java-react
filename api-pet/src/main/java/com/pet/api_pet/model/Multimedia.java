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
@Table(name = "multimedia")
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID multimediaId=UUID.randomUUID();

    private String urlMultimedia;

    @ManyToOne
    @JoinColumn(name = "pet_id",nullable = false,foreignKey = @ForeignKey(name = "FK_MULTIMEDIA_PET"))
    private Pet pet;
}
