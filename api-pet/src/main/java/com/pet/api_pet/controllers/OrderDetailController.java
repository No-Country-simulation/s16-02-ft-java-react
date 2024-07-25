package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.OrderDetailDTO;
import com.pet.api_pet.exception.ModelNotFoundException;
import com.pet.api_pet.model.eccomerce.OrderDetail;
import com.pet.api_pet.service.IOrderDetailService;
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
@RequestMapping("/api/orderDetail_detail")
public class OrderDetailController {
    
    @Autowired
    private IOrderDetailService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> findAll(){
        try {

            List<OrderDetailDTO> list = service.findAll().stream().map(p -> mapper.map(p, OrderDetailDTO.class)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ModelNotFoundException("No se encontraron extraviados");
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException("Error al obtener extraviados", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailDTO> findById(@PathVariable("id") UUID id){
        OrderDetail obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }else{
            return new ResponseEntity<>(mapper.map(obj, OrderDetailDTO.class), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderDetailDTO dto){
        OrderDetail obj = service.save(mapper.map(dto, OrderDetail.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getOrderdetailId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetailDTO dto){
        OrderDetail obj = service.update(mapper.map(dto, OrderDetail.class));
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        OrderDetail obj = service.findById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
