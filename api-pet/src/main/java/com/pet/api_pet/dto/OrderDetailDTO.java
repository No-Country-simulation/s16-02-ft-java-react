package com.pet.api_pet.dto;

import com.pet.api_pet.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {

    private UUID orderdetailId = UUID.randomUUID();
    private Integer detailQuantity;
    private Double detailPrice;
    private Order order;
}
