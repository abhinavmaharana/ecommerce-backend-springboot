package com.ecommerce.shoppers_store.controller;

import com.ecommerce.shoppers_store.model.Product;
import com.ecommerce.shoppers_store.model.Wishlist;
import com.ecommerce.shoppers_store.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing wishlists.
 */
@RestController
@RequestMapping("/api/v1/wishlists")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    /**
     * Creates a new wishlist.
     *
     * @param wishlist the wishlist to create
     * @return the created wishlist
     */
    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.saveWishlist(wishlist);
    }

    /**
     * Retrieves a wishlist by ID.
     *
     * @param id the wishlist ID
     * @return the wishlist
     */
    @GetMapping("/{id}")
    public Wishlist getWishlistById(@PathVariable String id) {
        return wishlistService.getWishlistById(id);
    }

    /**
     * Retrieves all wishlists.
     *
     * @return the list of wishlists
     */
    @GetMapping
    public List<Wishlist> getAllWishlists() {
        return wishlistService.getAllWishlists();
    }

    /**
     * Deletes a wishlist by ID.
     *
     * @param id the wishlist ID
     */
    @DeleteMapping("/{id}")
    public void deleteWishlist(@PathVariable String id) {
        wishlistService.deleteWishlist(id);
    }

    /**
     * Adds a product to a wishlist.
     *
     * @param wishlistId the wishlist ID
     * @param product the product to add
     */
    @PostMapping("/{wishlistId}/add")
    public void addProductToWishlist(@PathVariable String wishlistId, @RequestBody Product product) {
        wishlistService.addProductToWishlist(wishlistId, product);
    }

    /**
     * Removes a product from a wishlist.
     *
     * @param wishlistId the wishlist ID
     * @param product the product to remove
     */
    @PostMapping("/{wishlistId}/remove")
    public void removeProductFromWishlist(@PathVariable String wishlistId, @RequestBody Product product) {
        wishlistService.removeProductFromWishlist(wishlistId, product);
    }
}
