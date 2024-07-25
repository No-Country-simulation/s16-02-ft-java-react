package com.pet.api_pet.dto;

import com.pet.api_pet.model.Auditable;
import com.pet.api_pet.model.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO extends Auditable {

    private UUID orderId;
    private LocalDateTime orderDate;
    private String orderSerialCode;
    private OrderState orderState;
    private UserDTO user;
}
