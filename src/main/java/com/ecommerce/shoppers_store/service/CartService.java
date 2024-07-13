package com.ecommerce.shoppers_store.service;

import com.ecommerce.shoppers_store.model.Cart;
import com.ecommerce.shoppers_store.model.Product;
import com.ecommerce.shoppers_store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCartById(String id) {
        return cartRepository.findById(id).orElse(null);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }

    public void addProductToCart(String cartId, Product product) {
        Cart cart = getCartById(cartId);
        if (cart != null) {
            cart.getProducts().add(product);
            saveCart(cart);
        }
    }

    public void removeProductFromCart(String cartId, Product product) {
        Cart cart = getCartById(cartId);
        if (cart != null) {
            cart.getProducts().remove(product);
            saveCart(cart);
        }
    }
}
