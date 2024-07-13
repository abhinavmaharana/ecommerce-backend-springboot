package com.ecommerce.shoppers_store.service;

import com.ecommerce.shoppers_store.model.Product;
import com.ecommerce.shoppers_store.model.SaveForLater;
import com.ecommerce.shoppers_store.repository.SaveForLaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveForLaterService {
    @Autowired
    private SaveForLaterRepository saveForLaterRepository;

    public SaveForLater saveSaveForLater(SaveForLater saveForLater) {
        return saveForLaterRepository.save(saveForLater);
    }

    public SaveForLater getSaveForLaterById(String id) {
        return saveForLaterRepository.findById(id).orElse(null);
    }

    public List<SaveForLater> getAllSaveForLaters() {
        return saveForLaterRepository.findAll();
    }

    public void deleteSaveForLater(String id) {
        saveForLaterRepository.deleteById(id);
    }

    public void addProductToSaveForLater(String saveForLaterId, Product product) {
        SaveForLater saveForLater = getSaveForLaterById(saveForLaterId);
        if (saveForLater != null) {
            saveForLater.getProducts().add(product);
            saveSaveForLater(saveForLater);
        }
    }

    public void removeProductFromSaveForLater(String saveForLaterId, Product product) {
        SaveForLater saveForLater = getSaveForLaterById(saveForLaterId);
        if (saveForLater != null) {
            saveForLater.getProducts().remove(product);
            saveSaveForLater(saveForLater);
        }
    }
}
