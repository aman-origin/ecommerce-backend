package com.aman.ecommerce.cart.service;

import com.aman.ecommerce.cart.dto.AddToCartRequest;
import com.aman.ecommerce.cart.entity.Cart;
import com.aman.ecommerce.cart.entity.CartItem;
import com.aman.ecommerce.cart.repository.CartItemRepository;
import com.aman.ecommerce.cart.repository.CartRepository;
import com.aman.ecommerce.product.entity.Product;
import com.aman.ecommerce.product.repository.ProductRepository;
import com.aman.ecommerce.user.entity.User;
import com.aman.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void addToCart(AddToCartRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository.findAll().stream()
                .filter(c -> c.getUser().getId().equals(user.getId()))
                .findFirst()
                .orElseGet(() -> cartRepository.save(
                        Cart.builder().user(user).build()
                ));

        CartItem item = CartItem.builder()
                .cart(cart)
                .product(product)
                .quantity(request.getQuantity())
                .build();

        cartItemRepository.save(item);

    }
}