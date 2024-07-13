package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
