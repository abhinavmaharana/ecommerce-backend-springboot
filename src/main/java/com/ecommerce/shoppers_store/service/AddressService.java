package com.ecommerce.shoppers_store.service;

import com.ecommerce.shoppers_store.model.Address;
import com.ecommerce.shoppers_store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing addresses
 */

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> getAddressesByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void deleteAddress(String id) {
        addressRepository.deleteById(id);
    }
}
