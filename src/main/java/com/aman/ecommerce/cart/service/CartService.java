package com.aman.ecommerce.cart.service;

import com.aman.ecommerce.cart.dto.AddToCartRequest;

public interface CartService {

    void addToCart(AddToCartRequest request);

}