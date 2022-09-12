package com.deft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @PostMapping("/addresses")
    public Address createNewAddress(@RequestBody Address newAddress) {
        return repository.save(newAddress);
    }

    @PutMapping("/addresses/{id}")
    public Address update(@RequestBody Address newAddress, @PathVariable Long id) {

        return repository.findById(id)
                .map(address -> {
                    address.setCity(newAddress.getCity());
                    address.setPostalCode(newAddress.getPostalCode());
                    return repository.save(address);
                })
                .orElseGet(() -> repository.save(newAddress));
    }
}