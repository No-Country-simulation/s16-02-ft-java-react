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
@Table(name = "roles")
public class Role extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private UUID roleId=UUID.randomUUID();

    private String roleName;

    private String roleDescription;

    @OneToMany(mappedBy = "role",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User>users;
}
