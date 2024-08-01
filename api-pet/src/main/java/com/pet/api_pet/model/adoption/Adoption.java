package com.pet.api_pet.model.adoption;

import com.pet.api_pet.model.Auditable;
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
@Table(name = "adoptions")
public class Adoption extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "adoption_id")
    private UUID adoptionId=UUID.randomUUID();



    @Column(name = "adoption_date")
    private Instant adoptionDate=Instant.now();


    @OneToOne
    @JoinColumn(name = "application_id",nullable = false,foreignKey = @ForeignKey(name = "FK_ADOPTIONS_APPLICATION"))
    private Application application;


}
