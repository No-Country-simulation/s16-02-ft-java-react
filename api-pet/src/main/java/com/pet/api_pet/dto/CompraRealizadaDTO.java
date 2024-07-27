package com.pet.api_pet.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraRealizadaDTO {
    @Id
    private Long id;
    private String title;
    private String description;
    private String pictureUrl;
    private String categoryId;
    private int quantity;
    private String currencyId;
    private BigDecimal unitPrice;
}
