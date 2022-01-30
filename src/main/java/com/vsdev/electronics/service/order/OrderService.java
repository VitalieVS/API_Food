package com.vsdev.electronics.service.order;

import com.vsdev.electronics.dto.OrderResponse;
import com.vsdev.electronics.entity.order.Order;
import com.vsdev.electronics.entity.user.User;
import com.vsdev.electronics.repository.order.OrderRepository;
import com.vsdev.electronics.repository.user.UserRepository;
import com.vsdev.electronics.service.accessors.DateAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final DateAccessor dateAccessor;

    @Inject
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        DateAccessor dateAccessor) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.dateAccessor = dateAccessor;
    }

    public OrderResponse createOrder(Order order) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<User> currentUser = userRepository.findUserByLogin(userDetails.getUsername());

        OrderResponse orderResponse =
                new OrderResponse(false, dateAccessor.getDate(), "Error occurred while creating order!");


        if (currentUser.isPresent()) {

            List<Order> newOrderList = new ArrayList<>(currentUser.get().getOrdersList());

            this.orderRepository.save(order);

            newOrderList.add(order);

            currentUser.get().setOrdersList(newOrderList);

            userRepository.save(currentUser.get());

            orderResponse.setCreated(true);
            orderResponse.setMessage("Order created!");
        }

        return orderResponse;
    }
}
