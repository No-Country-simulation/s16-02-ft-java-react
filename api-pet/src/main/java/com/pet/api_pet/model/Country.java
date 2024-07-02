package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    private String countryName;

    @OneToMany(mappedBy = "country",cascade = {CascadeType.ALL}, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Department>departments;
}
