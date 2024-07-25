package com.pet.api_pet.service;

import com.pet.api_pet.model.MultimediaBlog;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IMultimediaBlogService extends ICRUDService<MultimediaBlog, UUID>{
    List<MultimediaBlog> findAllByArticleId(UUID id);
}
