package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.eccomerce.Order;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IOrderRepo;
import com.pet.api_pet.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl extends CRUDServiceImpl<Order, UUID> implements IOrderService {

    @Autowired
    private IOrderRepo repo;

    @Override
    public List<Order> findByUserId(UUID id) {
        return repo.findByUserId(id);
    }

    @Override
    protected IGenericRepo<Order, UUID> getRepo() {
        return repo;
    }
}
