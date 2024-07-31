package com.pet.api_pet.repository;

import com.pet.api_pet.model.adoption.Multimedia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IMultimediaRepo extends IGenericRepo<Multimedia, UUID> {
    @Query(value = "SELECT m.multimedia_id, m.pet_id, m.url_multimedia, m.principal FROM multimedia m WHERE m.pet_id",nativeQuery = true)
    List<Multimedia> getPhotosByPetId(@PathVariable("id") UUID id);
}
