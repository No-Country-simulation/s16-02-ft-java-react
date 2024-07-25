package com.pet.api_pet.service;

import com.pet.api_pet.model.Order;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface IOrderService extends ICRUDService<Order, UUID> {

    List<Order> findByUserId(UUID id);
}
