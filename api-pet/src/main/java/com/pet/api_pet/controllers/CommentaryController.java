package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.CommentaryDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.blog.Commentary;
import com.pet.api_pet.service.ICommentaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/commentaries")
public class CommentaryController {
    @Autowired
    private ICommentaryService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CommentaryDTO>> findAll(){
        try {

            List<CommentaryDTO> list = service.findAll().stream().map(p -> mapper.map(p, CommentaryDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron comentarios");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener comentarios", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentaryDTO> findById(@PathVariable("id") Long id){
        Optional<Commentary> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, CommentaryDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CommentaryDTO dto){
        Commentary obj = service.save(mapper.map(dto, Commentary.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCommentId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Commentary> update(@RequestBody CommentaryDTO dto){
        Commentary obj = service.update(mapper.map(dto, Commentary.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Optional<Commentary> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<List<CommentaryDTO>> findAllByArticleId(@PathVariable("id") Long id){
        try {

            List<CommentaryDTO> list = service.findAllByArticleId(id).stream().map(p -> mapper.map(p, CommentaryDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron comentarios");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener comentarios", e);
        }
    }
}
