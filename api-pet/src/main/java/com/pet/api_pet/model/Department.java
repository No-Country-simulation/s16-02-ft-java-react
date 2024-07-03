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
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false,foreignKey = @ForeignKey(name = "FK_DEPARTMENTS_COUNTRY"))
    private Country country;

    @OneToMany(mappedBy = "department",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<City>cities;
}
