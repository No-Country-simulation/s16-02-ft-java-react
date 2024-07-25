package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.PointsDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.Points;
import com.pet.api_pet.service.IPointsService;
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
@RequestMapping("/api/point")
public class PointsController {

    @Autowired
    private IPointsService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PointsDTO>> findAll(){
        try {

            List<PointsDTO> list = service.findAll().stream().map(p -> mapper.map(p, PointsDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener puntos", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointsDTO> findById(@PathVariable("id") UUID id){
        Points obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, PointsDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PointsDTO dto){
        Points obj = service.save(mapper.map(dto, Points.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getPointId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Points> update(@RequestBody PointsDTO dto){
        Points obj = service.update(mapper.map(dto, Points.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Points obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
