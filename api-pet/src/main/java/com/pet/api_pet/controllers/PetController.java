package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.PetDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.Pet;
import com.pet.api_pet.service.IPetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private IPetService service;

    @Autowired
    private ModelMapper mapper;
    

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PetDTO petDTO) {
        Pet pet = service.save(mapper.map(petDTO, Pet.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pet.getPetId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable("id") UUID id) {
        Pet pet = service.findById(id);
        if (pet == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @PutMapping("/update")
    public ResponseEntity<Pet> update(@RequestBody PetDTO petDTO) {
        Pet pet = service.update(mapper.map(petDTO, Pet.class));
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> findById(@PathVariable("id") UUID id) {
        Pet pet = service.findById(id);
        if (pet == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            return new ResponseEntity<>(mapper.map(pet, PetDTO.class), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @GetMapping("/petsList")
    public ResponseEntity<List<PetDTO>> findAll() {
        try {
            List<PetDTO> pets = service.findAll().stream()
                    .map(pet -> mapper.map(pet, PetDTO.class))
                    .collect(Collectors.toList());
            if (pets.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron pets");
            }
            return new ResponseEntity<>(pets, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el listado de pets", e);
        }
    }
/*
    @GetMapping("/byUserId/{id}")
    public ResponseEntity<PetDTO> findByUserId(@PathVariable("id") UUID id) {
        Pet usuario = service.findByUserId(id);
        if (usuario == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            return new ResponseEntity<>(mapper.map(usuario, PetDTO.class), HttpStatus.OK);
        }
    }*/
}
