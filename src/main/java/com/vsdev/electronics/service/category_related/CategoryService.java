package com.vsdev.electronics.service.category_related;

import com.vsdev.electronics.entity.product_related.Category;
import com.vsdev.electronics.repository.category_related.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
