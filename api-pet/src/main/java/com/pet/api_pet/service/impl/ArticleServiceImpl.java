package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Article;
import com.pet.api_pet.repository.IArticleRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends CRUDServiceImpl<Article,Long> implements IArticleService {
    @Autowired
    private IArticleRepo repo;
    @Override
    protected IGenericRepo<Article, Long> getRepo() {
        return repo;
    }
}
