package com.pet.api_pet.repository;

import com.pet.api_pet.model.Multimedia;
import com.pet.api_pet.model.MultimediaBlog;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface IMultimediaRepo extends IGenericRepo<Multimedia, UUID> {
}
