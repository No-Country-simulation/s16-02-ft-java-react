package com.pet.api_pet.service.impl;

import com.pet.api_pet.model.SubCategory;
import com.pet.api_pet.repository.IGenericRepo;
import com.pet.api_pet.repository.ISubCategoryRepo;
import com.pet.api_pet.service.ISubCategoryService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl extends CRUDServiceImpl<SubCategory, UUID> 
        implements ISubCategoryService {

    @Autowired
    private ISubCategoryRepo repo;
    
    @Override
    protected IGenericRepo<SubCategory, UUID> getRepo() {
        
        return repo;       
    }  
    
}
