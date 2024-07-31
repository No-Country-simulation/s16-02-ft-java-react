package com.pet.api_pet.repository;

import com.pet.api_pet.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface IProfileRepo extends IGenericRepo<Profile, UUID> {

    @Query(value = "SELECT p.active, p.created_at, p.deleted_at, p.district_id, p.updated_at, p.profile_document_number, p.profile_phone, p.created_by, p.deleted_by, p.profile_id, p.updated_by, p.user_id, p.profile_name, p.profile_last_name, p.profile_address, p.profile_document_type, p.profile_img_document \n" +
            "FROM profiles p WHERE p.user_id=:id",nativeQuery = true)
    Profile findByUserId(@PathVariable("id") UUID id);
}
