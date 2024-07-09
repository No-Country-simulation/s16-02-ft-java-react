package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.Pet;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IPetRepo;
import com.pet.api_pet.repository.specification.PetSpecification;
import com.pet.api_pet.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetServiceImpl extends CRUDServiceImpl<Pet, UUID> implements IPetService {

    @Autowired
    private IPetRepo repo;

    @Override
    protected IGenericRepo<Pet, UUID> getRepo() {
        return repo;
    }

    @Override
    public Page<Pet> getFilteredPets(String petName, String petSex, String petBreed, String petSize, String petType, Integer minAge, Integer maxAge, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Pet> spec = Specification.where(PetSpecification.hasName(petName))
                .and(PetSpecification.hasSex(petSex))
                .and(PetSpecification.hasBreed(petBreed))
                .and(PetSpecification.hasSize(petSize))
                .and(PetSpecification.hasType(petType))
                .and(PetSpecification.hasAge(minAge, maxAge));
        return repo.findAll(spec,pageable);
    }

    @Override
    public List<Pet> findAllPetsByShelterId(UUID shelterId) {
        return repo.findAllPetsByShelterId(shelterId);
    }
}
