package com.vsdev.electronics.repository.category_related;

import com.vsdev.electronics.entity.product_related.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
