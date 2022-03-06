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
import java.util.concurrent.ThreadLocalRandom;

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

            double totalOrderPrice = 0;

            if (order.getProductList().size() > 0) {

                for (int i = 0; i < order.getProductList().size(); i++) {

                    totalOrderPrice += order.getProductList().get(i).getPrice() *
                            order.getProductList().get(i).getQuantity();
                }
            }

            if (order.getPromotionList().size() > 0) {

                for (int i = 0; i < order.getPromotionList().size(); totalOrderPrice +=
                        order.getPromotionList().get(i++).getPrice())
                    ;
            }

            order.setTotalPrice(totalOrderPrice);

            List<Order> newOrderList = new ArrayList<>(currentUser.get().getOrdersList());

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            order.setOrderDate(sqlDate);

            int randomNum = ThreadLocalRandom.current().nextInt(1, 30 + 1);
            order.setImageUrl("http://10.0.2.2:4546/images/" + randomNum + ".png");

            this.orderRepository.save(order);

            newOrderList.add(order);

            currentUser.get().setOrdersList(newOrderList);

            userRepository.save(currentUser.get());

            calculateTotalSpentMoney();

            orderResponse.setCreated(true);
            orderResponse.setMessage("Order created!");
        }

        return orderResponse;
    }

    private void calculateTotalSpentMoney() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<User> currentUser = userRepository.findUserByLogin(userDetails.getUsername());

        if (currentUser.isPresent()) {

            float totalSpentMoney = 0;

            for (Order order : currentUser.get().getOrdersList()) {

                totalSpentMoney += order.getTotalPrice();
            }

            currentUser.get().setTotalSpentMoney(totalSpentMoney);

            userRepository.save(currentUser.get());
        }
    }
}
