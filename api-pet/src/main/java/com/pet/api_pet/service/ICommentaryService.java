package com.pet.api_pet.service;

import com.pet.api_pet.model.blog.Commentary;

import java.util.List;

public interface ICommentaryService extends ICRUDService<Commentary,Long>{
    List<Commentary> findAllByArticleId(Long id);
}
