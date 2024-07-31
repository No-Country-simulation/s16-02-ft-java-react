package com.pet.api_pet.service;

import com.pet.api_pet.model.eccomerce.Order;

import java.util.List;
import java.util.UUID;

public interface IOrderService extends ICRUDService<Order, UUID> {

    List<Order> findByUserId(UUID id);
}
