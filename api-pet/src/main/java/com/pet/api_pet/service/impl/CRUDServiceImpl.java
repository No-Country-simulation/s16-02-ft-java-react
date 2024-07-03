package com.pet.api_pet.service.impl;

import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.service.ICRUDService;

import java.util.List;

public abstract class CRUDServiceImpl<T, ID> implements ICRUDService<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t) {
        return getRepo().save(t);
    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);

    }
}
