package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.ArticleDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.Article;
import com.pet.api_pet.service.IArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private IArticleService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> findAll(){
        try {

            List<ArticleDTO> list = service.findAll().stream().map(p -> mapper.map(p, ArticleDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron articulos");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener articulos", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> findById(@PathVariable("id") Long id){
        Article obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, ArticleDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ArticleDTO dto){
        Article obj = service.save(mapper.map(dto, Article.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getArticleId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Article> update(@RequestBody ArticleDTO dto){
        Article obj = service.update(mapper.map(dto, Article.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Article obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
