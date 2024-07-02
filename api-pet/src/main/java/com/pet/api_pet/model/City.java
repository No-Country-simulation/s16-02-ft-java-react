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
@Table(name="cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String cityName;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false,foreignKey = @ForeignKey(name = "FK_CITIES_DEPARTMENT"))
    private Department department;

    @OneToMany(mappedBy = "city",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<District>districts;
}
