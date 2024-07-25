package com.pet.api_pet.model.eccomerce;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subCategory")
public class SubCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subCategory_id")
    private UUID subCategoryId=UUID.randomUUID();
    
    private String subCategoryName;
    
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false,foreignKey = @ForeignKey(name = "FK_CATEGORY_SUBCATEGORIES"))
    private Category category;
    
}
