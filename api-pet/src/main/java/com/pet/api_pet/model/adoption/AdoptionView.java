package com.pet.api_pet.model.adoption;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.View;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
/*@View(query = "CREATE VIEW adoption_view AS\n" +
        "SELECT a.adoption_date,a.adoption_id, a.application_id,p.profile_name,p.profile_last_name,pe.pet_id,pe.pet_name,s.shelter_id,s.shelter_name\n" +
        "\tFROM adoptions a\n" +
        "\tINNER JOIN applications ap\n" +
        "\tON ap.application_id=a.application_id\n" +
        "\tINNER JOIN profiles p\n" +
        "\tON p.profile_id=ap.profile_id\n" +
        "\tINNER JOIN pets pe\n" +
        "\tON pe.pet_id=ap.pet_id\n" +
        "\tINNER JOIN shelters s\n" +
        "\tON s.shelter_id=pe.shelter_id")*/
@View(query = "Select * from adoption_View")
public class AdoptionView {

    @Id
    @Column(name = "adoption_id")
    private UUID adoptionId;

    @Column(name="adoption_date")
    private Instant adoptionDate;

    @Column(name="application_id")
    private UUID applicationId;

    @Column(name="profile_name")
    private String profileName;

    @Column(name="profile_last_name")
    private String profileLastName;

    @Column(name="pet_id")
    private UUID petId;

    @Column(name="pet_name")
    private String petName;

    @Column(name="shelter_id")
    private UUID shelterId;

    @Column(name="shelter_name")
    private String shelterName;

    @Column(name = "user_id")
    private UUID userId;
}
