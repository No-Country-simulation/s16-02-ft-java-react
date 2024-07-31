package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "visit_id")
    private UUID visitId=UUID.randomUUID();

    private String visitDate;

    private String visitHour;

    private String visitReason;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false,foreignKey = @ForeignKey(name = "FK_VISITS_PROFILE"))
    private Profile profile;


}
