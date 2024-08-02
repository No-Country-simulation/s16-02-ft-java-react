package com.pet.api_pet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pet.api_pet.model.adoption.Shelter;
import com.pet.api_pet.model.auth.Profile;
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
    @JsonIgnore
    private City city;

    @OneToMany(mappedBy = "district",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Profile>profiles;

    @OneToMany(mappedBy = "district",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Shelter>shelters;

}
