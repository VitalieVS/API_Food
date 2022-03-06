package com.vsdev.electronics.controller.address;

import com.vsdev.electronics.dto.AddressRequest;
import com.vsdev.electronics.dto.AddressResponse;
import com.vsdev.electronics.service.address.AddressService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Inject
    public AddressController(AddressService addressService) {

        this.addressService = addressService;

    }

    @PutMapping("/user/address")
    public AddressResponse changeAddress(@RequestBody AddressRequest addressRequest) {

        return addressService.changeAddress(addressRequest);
    }
}
