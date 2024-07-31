package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.ShelterDTO;
import com.pet.api_pet.exception.ModelNotFoundException;

import com.pet.api_pet.model.adoption.Shelter;
import com.pet.api_pet.service.IShelterService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/shelter")
public class ShelterController {

    @Autowired
    private IShelterService service;

    @Autowired
    private ModelMapper mapper;

   /* @PostMapping("/register")
    public ResponseEntity registerShelter(@RequestBody @Valid ShelterDTO shelterDTO) {
        Shelter shelter = service.save(mapper.map(shelterDTO, Shelter.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(shelterDTO);
    }*/

   @PostMapping
   public ResponseEntity<Void> save(@RequestBody ShelterDTO shelterDTO) {
       Shelter shelter = service.save(mapper.map(shelterDTO, Shelter.class));
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(shelter.getShelterId()).toUri();
       return ResponseEntity.created(location).build();
  }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShelter(@PathVariable("id") UUID id) {
        Optional<Shelter> shelter = service.findById(id);
        if (shelter.isEmpty()) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('ROLE_SHELTER')")
    @PutMapping("/update")
    public ResponseEntity<Shelter> update(@RequestBody ShelterDTO shelterDTO) {
        Shelter shelter = service.update(mapper.map(shelterDTO, Shelter.class));
        return new ResponseEntity<>(shelter, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShelterDTO> findById(@PathVariable("id") UUID id) {
        Optional<Shelter> shelter = service.findById(id);
        if (shelter.isEmpty()) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            return new ResponseEntity<>(mapper.map(shelter, ShelterDTO.class), HttpStatus.OK);
        }
    }

    @GetMapping("/sheltersList")
    public ResponseEntity<List<ShelterDTO>> findAll() {
        try {
            List<ShelterDTO> shelters = service.findAll().stream()
                    .map(shelter -> mapper.map(shelter, ShelterDTO.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(shelters, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el listado de refugios", e);
        }
    }

    @GetMapping("/byUserId/{id}")
    public ResponseEntity<ShelterDTO> findByUserId(@PathVariable("id") UUID id) {
        Shelter shelter = service.findByUserId(id);
        if (shelter == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            return new ResponseEntity<>(mapper.map(shelter, ShelterDTO.class), HttpStatus.OK);
        }
    }

}
