package com.aman.ecommerce.order.service;

import com.aman.ecommerce.order.dto.CreateOrderRequest;

public interface OrderService {

    void createOrder(CreateOrderRequest request);

}