package com.aman.ecommerce.payment.service;

import com.aman.ecommerce.order.entity.Order;
import com.aman.ecommerce.order.repository.OrderRepository;
import com.aman.ecommerce.payment.dto.CreatePaymentRequest;
import com.aman.ecommerce.payment.entity.Payment;
import com.aman.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public void makePayment(CreatePaymentRequest request) {

        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Payment payment = Payment.builder()
                .order(order)
                .amount(order.getTotalPrice())
                .paymentMethod(request.getPaymentMethod())
                .status("SUCCESS")
                .createdAt(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);

        order.setStatus("PAID");
        orderRepository.save(order);

    }
}
