package com.pet.api_pet.controllers;


import com.pet.api_pet.dto.ProfileDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.Profile;
import com.pet.api_pet.service.IProfileService;
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
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private IProfileService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    public ResponseEntity<List<ProfileDTO>> findAll(){
        try {

            List<ProfileDTO> list = service.findAll().stream().map(p -> mapper.map(p, ProfileDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
                throw new RuntimeException("Error al obtener perfiles", e);
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable("id") UUID id){
        Profile obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, ProfileDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    public ResponseEntity<Void> save(@RequestBody ProfileDTO dto){
        Profile obj = service.save(mapper.map(dto, Profile.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getProfileId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Profile> update(@RequestBody ProfileDTO dto){
        Profile obj = service.update(mapper.map(dto, Profile.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Profile obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byUserId/{id}")
    public ResponseEntity<ProfileDTO> findByUserId(@PathVariable("id") UUID id) {
        Profile obj = service.findByUserId(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            return new ResponseEntity<>(mapper.map(obj, ProfileDTO.class), HttpStatus.OK);
        }
    }
}
