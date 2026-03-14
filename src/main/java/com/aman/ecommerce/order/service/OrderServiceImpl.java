package com.aman.ecommerce.order.service;

import com.aman.ecommerce.cart.entity.Cart;
import com.aman.ecommerce.cart.repository.CartRepository;
import com.aman.ecommerce.order.dto.CreateOrderRequest;
import com.aman.ecommerce.order.entity.Order;
import com.aman.ecommerce.order.repository.OrderRepository;
import com.aman.ecommerce.user.entity.User;
import com.aman.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public void createOrder(CreateOrderRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findAll().stream()
                .filter(c -> c.getUser().getId().equals(user.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Order order = Order.builder()
                .user(user)
                .status("CREATED")
                .createdAt(LocalDateTime.now())
                .build();

        orderRepository.save(order);

    }
}