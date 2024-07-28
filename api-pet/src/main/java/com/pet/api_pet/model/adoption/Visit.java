package com.pet.api_pet.model.adoption;

import com.pet.api_pet.model.auth.Profile;
import com.pet.api_pet.model.auth.User;
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
    @JoinColumn(name = "user_id", nullable = false,foreignKey = @ForeignKey(name = "FK_VISITS_USER"))
    private User user;


}
