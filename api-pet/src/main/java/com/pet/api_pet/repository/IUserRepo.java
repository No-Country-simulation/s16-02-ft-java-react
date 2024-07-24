package com.pet.api_pet.repository;

import com.pet.api_pet.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepo extends IGenericRepo<User, UUID> {
    @Query(value = "SELECT u.active, u.created_at, u.deleted_at, u.updated_at, u.created_by, u.deleted_by, u.role_id, u.updated_by, u.user_id, u.password, u.username,u.first_name,u.auth_provider\n" +
            "\tFROM users u WHERE u.username=:username",nativeQuery = true)
    Optional<User> findByUsername(@PathVariable("username") String username);
}
