package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.DonationDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.adoption.Donation;
import com.pet.api_pet.service.IDonationService;
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
@RequestMapping("/api/donations")
public class DonationController {

    @Autowired
    private IDonationService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<DonationDTO>> findAll(){
        try {

            List<DonationDTO> list = service.findAll().stream().map(p -> mapper.map(p, DonationDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron donaciones");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener donaciones", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationDTO> findById(@PathVariable("id") UUID id){
        Optional<Donation> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, DonationDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody DonationDTO dto){
        Donation obj = service.save(mapper.map(dto, Donation.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getDonationId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Donation> update(@RequestBody DonationDTO dto){
        Donation obj = service.update(mapper.map(dto, Donation.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Optional<Donation> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
