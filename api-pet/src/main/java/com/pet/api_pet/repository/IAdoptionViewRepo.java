package com.pet.api_pet.repository;

import com.pet.api_pet.model.adoption.AdoptionView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IAdoptionViewRepo extends IGenericRepo<AdoptionView, UUID> {
    @Query(value = "SELECT a.adoption_date, a.adoption_id, a.application_id, a.profile_name, a.profile_last_name, a.pet_id, a.pet_name, a.shelter_id, a.shelter_name,a.user_id FROM adoption_view a WHERE a.user_id=:id",nativeQuery = true)
    List<AdoptionView> findAllAdoptionByUserId(@PathVariable("id") UUID id);

}
