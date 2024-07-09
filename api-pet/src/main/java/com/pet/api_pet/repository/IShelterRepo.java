package com.pet.api_pet.repository;

import com.pet.api_pet.model.Shelter;

import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface IShelterRepo extends IGenericRepo<Shelter, UUID> {
    
    @Query(value = " SELECT s.shelter_id, s.shelter_name, s.shelter_authorization, s.shelter_img_authorization, s.shelter_address, s.user_id, s.district_id, s.created_at, s.created_by, s.updated_at, s.updated_by, s.deleted_at, s.deleted_by, s.active FROM shelters s WHERE s.user_id =:id ", nativeQuery = true)
    Shelter findByUserId(@PathVariable("id") UUID id);
}
