package com.vsdev.electronics.repository.address;

import com.vsdev.electronics.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
