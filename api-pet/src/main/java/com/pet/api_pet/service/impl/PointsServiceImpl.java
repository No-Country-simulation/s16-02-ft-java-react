package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.adoption.Points;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IPointsRepo;
import com.pet.api_pet.service.IPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PointsServiceImpl extends CRUDServiceImpl<Points, UUID> implements IPointsService {

    @Autowired
    private IPointsRepo repo;


    @Override
    protected IGenericRepo<Points, UUID> getRepo() {
        return repo;
    }
}
