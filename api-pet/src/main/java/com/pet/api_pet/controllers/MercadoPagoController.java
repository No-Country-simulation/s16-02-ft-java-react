package com.pet.api_pet.controllers;

import com.pet.api_pet.dto.CompraRealizadaDTO;
import com.pet.api_pet.model.CompraRealizada;
import com.pet.api_pet.service.IMercadoPagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mercadoPago")
public class MercadoPagoController {

    @Autowired
    private IMercadoPagoService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/preferenceId")
    public String getList(@RequestBody List<CompraRealizadaDTO> productos) {
        if (productos == null || productos.isEmpty()) {
            return "La lista de productos es nula o está vacía";
        } else {
            return service.ProductoId(productos);
        }
    }

    @PostMapping("/guardarCompra")
    public ResponseEntity<String> save(@RequestBody List<CompraRealizadaDTO> productos) {
        List<CompraRealizada> compraRealizadaList = productos.stream()
                .map(producto -> mapper.map(producto, CompraRealizada.class))
                .collect(Collectors.toList());

        compraRealizadaList.forEach(service::save);

        return ResponseEntity.ok("La compra fue realizada");
    }
}