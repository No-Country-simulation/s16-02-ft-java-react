package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.MultimediaDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.adoption.Multimedia;
import com.pet.api_pet.service.IMultimediaService;
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
@RequestMapping("/api/multimedia")
public class MultimediaController {

    @Autowired
    private IMultimediaService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MultimediaDTO>> findAll(){
        try {

            List<MultimediaDTO> list = service.findAll().stream().map(p -> mapper.map(p, MultimediaDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron multimedia");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener multimedia", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultimediaDTO> findById(@PathVariable("id") UUID id){
        Optional<Multimedia> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, MultimediaDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody MultimediaDTO dto){
        Multimedia obj = service.save(mapper.map(dto, Multimedia.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getMultimediaId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Multimedia> update(@RequestBody MultimediaDTO dto){
        Multimedia obj = service.update(mapper.map(dto, Multimedia.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Optional<Multimedia> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
