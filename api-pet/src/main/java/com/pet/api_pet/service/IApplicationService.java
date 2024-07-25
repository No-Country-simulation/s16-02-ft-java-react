package com.pet.api_pet.service;

import com.pet.api_pet.model.adoption.Application;

import java.util.List;
import java.util.UUID;

public interface IApplicationService extends ICRUDService<Application, UUID> {
    List<Application> findAllByUserid(UUID id);

}
