package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.eccomerce.Product;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.IProductRepo;
import com.pet.api_pet.service.IProductService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl 
        extends CRUDServiceImpl<Product, UUID> 
        implements IProductService {

    @Autowired
    private IProductRepo repo;
    
    @Override
    protected IGenericRepo<Product, UUID> getRepo() {
        
        return repo;       
    }  
}
