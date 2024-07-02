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
@Table(name = "points")
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "point_id")
    private UUID pointId=UUID.randomUUID();

    @Column(name = "point_number",nullable = false,length = 10)
    private Long pointNumber;

    @ManyToOne
    @JoinColumn(name = "profile_id",nullable = false,foreignKey = @ForeignKey(name = "FK_POINTS_PROFILE"))
    private Profile profile;
}
