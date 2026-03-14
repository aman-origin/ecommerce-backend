package com.aman.ecommerce.cart.repository;

import com.aman.ecommerce.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}