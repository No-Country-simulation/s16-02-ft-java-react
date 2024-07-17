package com.pet.api_pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable{

    // Usuario quien adopta se llame al Perfil multihilos
    //
    // Usuario
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId=UUID.randomUUID();

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false,foreignKey = @ForeignKey(name="FK_USERS_ROLE"))
    private Role role;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private Profile profile;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Shelter> shelters;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Lost> lost;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;
}
