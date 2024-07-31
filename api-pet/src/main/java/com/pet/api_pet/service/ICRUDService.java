package com.pet.api_pet.service;

import java.util.List;
import java.util.Optional;

public interface ICRUDService <T,ID>{
    T save(T t);
    T update(T t);
    Optional<T> findById(ID id);
    List<T> findAll();
    void delete(ID id);
}
