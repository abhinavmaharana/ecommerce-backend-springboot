package com.ecommerce.shoppers_store.controller;

import com.ecommerce.shoppers_store.model.Product;
import com.ecommerce.shoppers_store.model.SaveForLater;
import com.ecommerce.shoppers_store.service.SaveForLaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing save for later items.
 */
@RestController
@RequestMapping("/api/v1/saveforlater")
public class SaveForLaterController {
    @Autowired
    private SaveForLaterService saveForLaterService;

    /**
     * Creates a new save for later list.
     *
     * @param saveForLater the save for later list to create
     * @return the created save for later list
     */
    @PostMapping
    public SaveForLater createSaveForLater(@RequestBody SaveForLater saveForLater) {
        return saveForLaterService.saveSaveForLater(saveForLater);
    }

    /**
     * Retrieves a save for later list by ID.
     *
     * @param id the save for later list ID
     * @return the save for later list
     */
    @GetMapping("/{id}")
    public SaveForLater getSaveForLaterById(@PathVariable String id) {
        return saveForLaterService.getSaveForLaterById(id);
    }

    /**
     * Retrieves all save for later lists.
     *
     * @return the list of save for later lists
     */
    @GetMapping
    public List<SaveForLater> getAllSaveForLaters() {
        return saveForLaterService.getAllSaveForLaters();
    }

    /**
     * Deletes a save for later list by ID.
     *
     * @param id the save for later list ID
     */
    @DeleteMapping("/{id}")
    public void deleteSaveForLater(@PathVariable String id) {
        saveForLaterService.deleteSaveForLater(id);
    }

    /**
     * Adds a product to a save for later list.
     *
     * @param saveForLaterId the save for later list ID
     * @param product the product to add
     */
    @PostMapping("/{saveForLaterId}/add")
    public void addProductToSaveForLater(@PathVariable String saveForLaterId, @RequestBody Product product) {
        saveForLaterService.addProductToSaveForLater(saveForLaterId, product);
    }

    /**
     * Removes a product from a save for later list.
     *
     * @param saveForLaterId the save for later list ID
     * @param product the product to remove
     */
    @PostMapping("/{saveForLaterId}/remove")
    public void removeProductFromSaveForLater(@PathVariable String saveForLaterId, @RequestBody Product product) {
        saveForLaterService.removeProductFromSaveForLater(saveForLaterId, product);
    }
}
