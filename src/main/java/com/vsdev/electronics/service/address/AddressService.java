package com.vsdev.electronics.service.address;

import com.vsdev.electronics.dto.AddressRequest;
import com.vsdev.electronics.dto.AddressResponse;
import com.vsdev.electronics.entity.user.Address;
import com.vsdev.electronics.repository.address.AddressRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Inject
    public AddressService(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }

    public AddressResponse changeAddress(AddressRequest addressRequest) {

        AddressResponse addressResponse = new AddressResponse("Error", "Could not update address!");

        Optional<Address> addressInDB = addressRepository.findById(addressRequest.getId());

        if (addressInDB.isPresent()) {

            addressInDB.get().setFirstAddress(addressRequest.getFirstAddress());
            addressInDB.get().setSecondAddress(addressRequest.getSecondAddress());
            addressInDB.get().setCity(addressRequest.getCity());
            addressInDB.get().setCountry(addressRequest.getCountry());
            addressRepository.save(addressInDB.get());
            addressResponse.setError("Success!");
            addressResponse.setMessage("Successfully changed address!");
        }

        return addressResponse;
    }
}
