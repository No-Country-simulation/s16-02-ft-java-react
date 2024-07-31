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
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID productId=UUID.randomUUID();
    
    private String productName;
    
    private String productDescription;
    
    private double productWeight;
    
    private String productBrand;

/*    
    @OneToOne
    @JoinColumn(name = "subCategory_id",nullable = false,foreignKey = @ForeignKey(name = "FK_SUBCATEGORY"))
    private SubCategory subCategory;
*/    
    
}
