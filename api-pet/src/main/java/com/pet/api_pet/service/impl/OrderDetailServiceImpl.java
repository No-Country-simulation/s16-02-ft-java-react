package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.OrderDetail;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IOrderDetailRepo;
import com.pet.api_pet.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderDetailServiceImpl extends CRUDServiceImpl<OrderDetail, UUID> implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepo repo;

    @Override
    protected IGenericRepo<OrderDetail, UUID> getRepo() {
        return repo;
    }
}
