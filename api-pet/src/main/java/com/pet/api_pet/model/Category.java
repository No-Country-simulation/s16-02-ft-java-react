package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id")
    private UUID categoryId=UUID.randomUUID();

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<SubCategory>subCategories;
}
