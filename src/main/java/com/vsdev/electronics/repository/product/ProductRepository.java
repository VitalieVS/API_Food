package com.vsdev.electronics.repository.product;

import com.vsdev.electronics.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
