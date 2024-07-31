package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.ProductDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.eccomerce.Product;
import com.pet.api_pet.service.IProductService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private IProductService service;
    
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        try {

            List<ProductDTO> list = service.findAll().stream().map(p -> mapper.map(p, ProductDTO.class)).collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener productos", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") UUID id){
        Optional<Product> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, ProductDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductDTO dto){
        Product obj = service.save(mapper.map(dto, Product.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getProductId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody ProductDTO dto){
        Product obj = service.update(mapper.map(dto, Product.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
    Optional<Product> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
