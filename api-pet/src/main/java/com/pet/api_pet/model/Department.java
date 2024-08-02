package com.pet.api_pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Country country;

    @OneToMany(mappedBy = "department",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<City>cities;
}
