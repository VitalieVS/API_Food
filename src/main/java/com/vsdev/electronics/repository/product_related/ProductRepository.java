package com.vsdev.electronics.repository.product_related;

import com.vsdev.electronics.entity.product_related.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
