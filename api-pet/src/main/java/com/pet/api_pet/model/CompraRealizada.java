package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
public class CompraRealizada {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "compra_id")
    private UUID compraId=UUID.randomUUID();
    private String title;
    private String description;
    private String pictureUrl;
    private String categoryId;
    private int quantity;
    private String currencyId;
    private BigDecimal unitPrice;
}
