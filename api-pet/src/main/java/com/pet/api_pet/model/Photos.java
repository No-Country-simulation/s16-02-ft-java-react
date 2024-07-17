package com.pet.api_pet.model;

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
@Table(name = "photos")
public class Photos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "photo_id")
    private UUID photoId=UUID.randomUUID();
    
    private String photoUrl;
    
    
    @OneToOne
    @JoinColumn(name = "product_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PRODUCT_ID"))
    private Product product;

    
}
