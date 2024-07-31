package com.pet.api_pet.repository;

import com.pet.api_pet.model.adoption.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IApplicationRepo extends IGenericRepo<Application, UUID>{

    @Query(value = "SELECT a.application_id,a.application_number,a.pet_id,p.pet_name,a.user_id,pr.profile_name,s.shelter_id,s.shelter_name ,a.application_state, a.approved, a.active, a.created_at, a.deleted_at, a.updated_at, a.updated_by, a.created_by, a.deleted_by\n" +
            "\tFROM applications a\n" +
            "\tINNER JOIN pets p\n" +
            "\tON p.pet_id=a.pet_id\n" +
            "\tINNER JOIN shelters s\n" +
            "\tON s.shelter_id=p.shelter_id\n" +
            "\tINNER JOIN profiles pr\n" +
            "\tON pr.user_id=a.user_id\n" +
            "\tWHERE a.user_id=:id",nativeQuery = true)
   List<Application>findAllByUserid(@PathVariable("id") UUID id);

    @Query(value = "SELECT a.application_id,a.application_number,a.pet_id,p.pet_name,a.user_id,pr.profile_name,s.shelter_id,s.shelter_name ,a.application_state, a.approved, a.active, a.created_at, a.deleted_at, a.updated_at, a.updated_by, a.created_by, a.deleted_by\n" +
            "\tFROM applications a\n" +
            "\tINNER JOIN pets p\n" +
            "\tON p.pet_id=a.pet_id\n" +
            "\tINNER JOIN shelters s\n" +
            "\tON s.shelter_id=p.shelter_id\n" +
            "\tINNER JOIN profiles pr\n" +
            "\tON pr.user_id=a.user_id\n" +
            "\tWHERE s.shelter_id=:id",nativeQuery = true)
    List<Application>findAllByShelterId(@PathVariable("id") UUID id);
}
