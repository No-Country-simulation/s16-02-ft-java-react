package com.pet.api_pet.service;

import com.pet.api_pet.dto.CompraRealizadaDTO;
import com.pet.api_pet.model.CompraRealizada;

import java.util.List;
import java.util.UUID;

public interface IMercadoPagoService extends  ICRUDService<CompraRealizada, UUID>{
    String ProductoId(List<CompraRealizadaDTO> productos);
}
