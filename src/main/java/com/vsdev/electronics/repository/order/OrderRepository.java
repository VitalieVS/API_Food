package com.vsdev.electronics.repository.order;

import com.vsdev.electronics.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
