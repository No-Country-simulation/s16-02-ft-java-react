package com.pet.api_pet.repository;

import com.pet.api_pet.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface IOrderRepo extends IGenericRepo<Order, UUID> {

    @Query(value = "SELECT * FROM orders o WHERE o.user_id =: userid ", nativeQuery = true)
    List<Order> findByUserId(@PathVariable("userid") UUID id);

}
