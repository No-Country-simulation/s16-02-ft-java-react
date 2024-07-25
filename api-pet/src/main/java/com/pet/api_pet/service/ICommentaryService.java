package com.pet.api_pet.service;

import com.pet.api_pet.model.Commentary;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICommentaryService extends ICRUDService<Commentary,Long>{
    List<Commentary> findAllByArticleId(Long id);
}
