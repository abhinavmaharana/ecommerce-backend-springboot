package com.ecommerce.shoppers_store.controller;

import com.ecommerce.shoppers_store.model.Order;
import com.ecommerce.shoppers_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing orders.
 */
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * Creates a new order.
     *
     * @param order the order to create
     * @return the created order
     */
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    /**
     * Retrieves an order by ID.
     *
     * @param id the order ID
     * @return the order
     */
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    /**
     * Retrieves all orders.
     *
     * @return the list of orders
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * Deletes an order by ID.
     *
     * @param id the order ID
     */
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
}
