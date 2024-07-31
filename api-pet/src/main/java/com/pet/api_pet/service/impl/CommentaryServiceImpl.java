package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.blog.Commentary;
import com.pet.api_pet.repository.ICommentaryRepo;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.ICommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryServiceImpl extends CRUDServiceImpl<Commentary,Long> implements ICommentaryService {
    @Autowired
    private ICommentaryRepo repo;

    @Override
    protected IGenericRepo<Commentary,Long> getRepo() { return repo;}

    @Override
    public List<Commentary> findAllByArticleId(Long id) {
        return repo.findAllByArticleId(id);
    }
}
