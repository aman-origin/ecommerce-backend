package com.aman.ecommerce.cart.controller;

import com.aman.ecommerce.cart.dto.AddToCartRequest;
import com.aman.ecommerce.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestBody AddToCartRequest request) {
        cartService.addToCart(request);
    }

}