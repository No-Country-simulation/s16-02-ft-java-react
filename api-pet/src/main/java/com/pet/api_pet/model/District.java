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
@Table(name = "districts")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;

    private String districtName;

    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false,foreignKey = @ForeignKey(name = "FK_DISTRICTS_CITY"))
    private City city;

    @OneToMany(mappedBy = "district",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Profile>profiles;

    @OneToMany(mappedBy = "district",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Shelter>shelters;
}
