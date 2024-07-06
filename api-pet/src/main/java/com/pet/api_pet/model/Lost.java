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
@Table(name = "lost")
public class Lost extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lostId=UUID.randomUUID();

    @Column(name = "lat_x",nullable = false)
    private String latX;

    @Column(name = "lat_y",nullable = false)
    private String latY;

    @Column(name = "lost_description")
    private String lostDescription;

    @Column(name = "lost_reference")
    private String lostReference;

    @Column(name = "lost_address")
    private String lostAddress;

    @ManyToOne
    @JoinColumn(name = "pet_id",nullable = false,foreignKey = @ForeignKey(name = "FK_LOST_PET"))
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_LOST_USER"))
    private User user;
}
