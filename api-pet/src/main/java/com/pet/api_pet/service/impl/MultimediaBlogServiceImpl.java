package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.blog.MultimediaBlog;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IMultimediaBlogRepo;
import com.pet.api_pet.service.IMultimediaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class MultimediaBlogServiceImpl extends CRUDServiceImpl<MultimediaBlog, UUID> implements IMultimediaBlogService {
    @Autowired
    private IMultimediaBlogRepo repo;
    @Override
    public List<MultimediaBlog> findAllByArticleId(UUID id) {
        return repo.findAllByArticleId(id);
    }

    @Override
    protected IGenericRepo<MultimediaBlog, UUID> getRepo() {
        return repo;
    }
}
