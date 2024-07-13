package com.ecommerce.shoppers_store.service;

import com.ecommerce.shoppers_store.model.Product;
import com.ecommerce.shoppers_store.model.Wishlist;
import com.ecommerce.shoppers_store.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public Wishlist getWishlistById(String id) {
        return wishlistRepository.findById(id).orElse(null);
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public void deleteWishlist(String id) {
        wishlistRepository.deleteById(id);
    }

    public void addProductToWishlist(String wishlistId, Product product) {
        Wishlist wishlist = getWishlistById(wishlistId);
        if (wishlist != null) {
            wishlist.getProducts().add(product);
            saveWishlist(wishlist);
        }
    }

    public void removeProductFromWishlist(String wishlistId, Product product) {
        Wishlist wishlist = getWishlistById(wishlistId);
        if (wishlist != null) {
            wishlist.getProducts().remove(product);
            saveWishlist(wishlist);
        }
    }
}
