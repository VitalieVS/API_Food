package com.vsdev.electronics.repository.product_related;

import com.vsdev.electronics.entity.product_related.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(value = "SELECT * FROM promotions", nativeQuery = true)
    List<Promotion> findAllPromotions();
}
