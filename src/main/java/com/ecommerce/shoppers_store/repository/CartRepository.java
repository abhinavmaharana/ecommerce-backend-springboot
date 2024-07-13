package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {
}
