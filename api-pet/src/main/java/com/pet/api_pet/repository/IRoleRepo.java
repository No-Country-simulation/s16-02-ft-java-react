package com.pet.api_pet.repository;

import com.pet.api_pet.model.auth.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface IRoleRepo extends IGenericRepo<Role, UUID>{

    @Query(value = "SELECT r.role_id,r.role_name,r.role_description,r.active,r.updated_by,r.created_at,r.updated_at,r.created_by,r.deleted_at,r.deleted_by FROM roles r WHERE r.role_name=:roleName",nativeQuery = true)
    Role findRoleByName(String roleName);
}
