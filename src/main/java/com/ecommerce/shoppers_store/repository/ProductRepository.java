package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
