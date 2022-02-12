package com.vsdev.electronics.controller.product;

import com.vsdev.electronics.entity.product.Promotion;
import com.vsdev.electronics.repository.product.PromotionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class PromotionsController {


    private final PromotionRepository promotionRepository;

    @Inject
    public PromotionsController(PromotionRepository promotionRepository) {

        this.promotionRepository = promotionRepository;
    }

    @GetMapping("/promotions")
    public List<Promotion> getPromotions() {
        return promotionRepository.findAllPromotions();
    }
}
