package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.User;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IUserRepo;
import com.pet.api_pet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl extends CRUDServiceImpl<User, UUID> implements IUserService {
    @Autowired
    private IUserRepo repo;
    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    protected IGenericRepo<User, UUID> getRepo() {
        return repo;
    }
}
