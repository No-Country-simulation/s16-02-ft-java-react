package com.pet.api_pet.service;

import com.pet.api_pet.model.blog.MultimediaBlog;

import java.util.List;
import java.util.UUID;

public interface IMultimediaBlogService extends ICRUDService<MultimediaBlog, UUID>{
    List<MultimediaBlog> findAllByArticleId(UUID id);
}
