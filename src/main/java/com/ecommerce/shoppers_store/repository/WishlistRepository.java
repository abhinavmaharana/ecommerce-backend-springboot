package com.ecommerce.shoppers_store.repository;

import com.ecommerce.shoppers_store.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {
}
