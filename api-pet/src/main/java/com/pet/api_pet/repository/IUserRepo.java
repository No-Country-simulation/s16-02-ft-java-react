package com.pet.api_pet.repository;

import com.pet.api_pet.model.auth.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepo extends IGenericRepo<User, UUID> {
    @Query(value = "SELECT * FROM users u WHERE u.username=:username",nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);
}
