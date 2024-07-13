package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
