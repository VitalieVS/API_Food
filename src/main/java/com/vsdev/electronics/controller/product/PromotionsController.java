package com.vsdev.electronics.controller.product;

import com.vsdev.electronics.entity.product.Promotion;
import com.vsdev.electronics.repository.product.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionsController {

    @Autowired
    private PromotionRepository promotionRepository;

    @GetMapping("/promotions")
    public List<Promotion> getPromotions() {
        return promotionRepository.findAllPromotions();
    }
}
