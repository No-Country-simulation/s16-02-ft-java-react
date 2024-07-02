package com.pet.api_pet.repository;

import com.pet.api_pet.model.Role;

import java.util.UUID;

public interface IRoleRepo extends IGenericRepo<Role, UUID>{

    Role findRoleByName(String roleName);
}
