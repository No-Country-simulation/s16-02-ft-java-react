package com.pet.api_pet.repository;

import com.pet.api_pet.model.CompraRealizada;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface IMercadoPagoRepo extends IGenericRepo<CompraRealizada, UUID>, JpaSpecificationExecutor<CompraRealizada> {
}
