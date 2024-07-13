package com.ecommerce.shoppers_store.controller;

import com.ecommerce.shoppers_store.model.Cart;
import com.ecommerce.shoppers_store.model.Product;
import com.ecommerce.shoppers_store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing carts.
 */
@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * Creates a new cart.
     *
     * @param cart the cart to create
     * @return the created cart
     */
    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    /**
     * Retrieves a cart by ID.
     *
     * @param id the cart ID
     * @return the cart
     */
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable String id) {
        return cartService.getCartById(id);
    }

    /**
     * Retrieves all carts.
     *
     * @return the list of carts
     */
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    /**
     * Deletes a cart by ID.
     *
     * @param id the cart ID
     */
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
    }

    /**
     * Adds a product to a cart.
     *
     * @param cartId the cart ID
     * @param product the product to add
     */
    @PostMapping("/{cartId}/add")
    public void addProductToCart(@PathVariable String cartId, @RequestBody Product product) {
        cartService.addProductToCart(cartId, product);
    }

    /**
     * Removes a product from a cart.
     *
     * @param cartId the cart ID
     * @param product the product to remove
     */
    @PostMapping("/{cartId}/remove")
    public void removeProductFromCart(@PathVariable String cartId, @RequestBody Product product) {
        cartService.removeProductFromCart(cartId, product);
    }
}
