package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
