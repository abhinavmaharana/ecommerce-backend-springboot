package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, String> {
    List<Address> findByUserId(String userId);
}
