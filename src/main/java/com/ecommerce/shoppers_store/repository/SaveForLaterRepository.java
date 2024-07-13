package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.SaveForLater;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaveForLaterRepository extends MongoRepository<SaveForLater, String> {
}
