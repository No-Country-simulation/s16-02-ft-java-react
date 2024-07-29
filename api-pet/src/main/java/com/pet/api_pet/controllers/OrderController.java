package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.OrderDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.eccomerce.Order;
import com.pet.api_pet.service.IOrderService;
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
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        try {

            List<OrderDTO> list = service.findAll().stream().map(p -> mapper.map(p, OrderDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron extraviados");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener extraviados", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") UUID id){
        Optional<Order> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, OrderDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderDTO dto){
        Order obj = service.save(mapper.map(dto, Order.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getOrderId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody OrderDTO dto){
        Order obj = service.update(mapper.map(dto, Order.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        Optional<Order> obj = service.findById(id);
        if(obj.isEmpty()){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
