package com.pet.api_pet.service;

import com.pet.api_pet.model.adoption.Application;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IApplicationService extends ICRUDService<Application, UUID> {
    List<Application> findAllByUserid(UUID id);
    List<Application>findAllByShelterId(UUID id);

}
