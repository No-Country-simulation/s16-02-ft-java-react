package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.AdoptionDTO;
import com.pet.api_pet.dto.AdoptionViewDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.adoption.Adoption;
import com.pet.api_pet.service.IAdoptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/adoptions")
public class AdoptionController {
    @Autowired
    private IAdoptionService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<AdoptionDTO>> findAll(){
        try {

            List<AdoptionDTO> list = service.findAll().stream().map(p -> mapper.map(p, AdoptionDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener adopciones", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionDTO> findById(@PathVariable("id") UUID id){
        Optional<Adoption> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, AdoptionDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AdoptionDTO dto){
        Adoption obj = service.save(mapper.map(dto, Adoption.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getAdoptionId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Adoption> update(@RequestBody AdoptionDTO dto){
        Adoption obj = service.update(mapper.map(dto, Adoption.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Optional<Adoption> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<AdoptionViewDTO>> findAllByUserId(@PathVariable("id") UUID id){
        try {

            List<AdoptionViewDTO> list = service.findAllAdoptionByUserId(id).stream().map(p -> mapper.map(p, AdoptionViewDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener adopciones", e);
        }
    }
}
