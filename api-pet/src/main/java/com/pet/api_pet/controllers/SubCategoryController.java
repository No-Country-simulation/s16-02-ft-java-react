package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.SubCategoryDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.eccomerce.SubCategory;
import com.pet.api_pet.service.ISubCategoryService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {
    
    @Autowired
    private ISubCategoryService service;
    
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SubCategoryDTO>> findAll(){
        try {

            List<SubCategoryDTO> list = service.findAll().stream().map(p -> mapper.map(p, SubCategoryDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener Sub Categoria", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryDTO> findById(@PathVariable("id") UUID id){
        SubCategory obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, SubCategoryDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SubCategoryDTO dto){
        SubCategory obj = service.save(mapper.map(dto, SubCategory.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getSubCategoryId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SubCategory> update(@RequestBody SubCategoryDTO dto){
        SubCategory obj = service.update(mapper.map(dto, SubCategory.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        SubCategory obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    
}
