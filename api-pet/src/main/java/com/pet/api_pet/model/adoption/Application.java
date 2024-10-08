package com.pet.api_pet.model.adoption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.api_pet.model.Auditable;
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
@Table(name = "applications")
public class Application extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID applicationId=UUID.randomUUID();

    @Column(name = "application_number",nullable = false,length = 13)
    private String applicationNumber;//Código de solicitud de adopción Ejmpl: 0001-00000123;

    @Column(name = "application_state",nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    @Column(name = "approved")
    private Boolean approved=false;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_APPLICATIONS_USER"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "pet_id",nullable = false,foreignKey = @ForeignKey(name = "FK_APPLICATIONS_PET"))
    private Pet pet;

    @OneToOne(mappedBy = "application",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private Adoption adoption;

}
