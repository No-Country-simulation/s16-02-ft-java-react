package com.pet.api_pet.repository;

import com.pet.api_pet.model.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IApplicationRepo extends IGenericRepo<Application, UUID>{

    @Query(value = "SELECT a.active, a.created_at, a.deleted_at, a.updated_at, a.application_number, a.application_id, a.created_by, a.deleted_by, a.pet_id, a.profile_id, a.updated_by, a.application_state FROM applications a INNER JOIN profiles p ON p.profile_id=a.profile_id WHERE p.user_id=:id",nativeQuery = true)
    List<Application>findAllByUserid(@PathVariable("id") UUID id);
}
