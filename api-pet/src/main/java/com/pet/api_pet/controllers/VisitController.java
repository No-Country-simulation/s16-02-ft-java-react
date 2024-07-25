package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.VisitDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.Visit;
import com.pet.api_pet.service.IVisitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/visit")
public class VisitController {

    @Autowired
    private IVisitService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<VisitDTO>> findAll(){
        try {
            List<VisitDTO> list = service.findAll().stream().map(p -> mapper.map(p, VisitDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener visita", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> findById(@PathVariable("id") UUID id){
        Visit obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, VisitDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody VisitDTO dto){
        Visit obj = service.save(mapper.map(dto, Visit.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getVisitId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Visit> update(@RequestBody VisitDTO dto){
        Visit obj = service.update(mapper.map(dto, Visit.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Visit obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
