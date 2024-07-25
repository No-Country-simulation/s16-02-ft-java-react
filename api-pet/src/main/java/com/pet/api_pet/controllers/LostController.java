package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.LostDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.adoption.Lost;
import com.pet.api_pet.service.ILostService;
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
@RequestMapping("/api/lost")
public class LostController {
    @Autowired
    private ILostService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<LostDTO>> findAll(){
        try {

            List<LostDTO> list = service.findAll().stream().map(p -> mapper.map(p, LostDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron extraviados");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener extraviados", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostDTO> findById(@PathVariable("id") UUID id){
        Lost obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, LostDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody LostDTO dto){
        Lost obj = service.save(mapper.map(dto, Lost.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getLostId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Lost> update(@RequestBody LostDTO dto){
        Lost obj = service.update(mapper.map(dto, Lost.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Lost obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
