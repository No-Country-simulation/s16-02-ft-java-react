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
@Table(name = "users")
public class User extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId=UUID.randomUUID();

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false,foreignKey = @ForeignKey(name="FK_USERS_ROLE"))
    private Role role;
}
