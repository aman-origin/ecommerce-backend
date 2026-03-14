package com.aman.ecommerce.product.controller;

import com.aman.ecommerce.product.dto.CreateProductRequest;
import com.aman.ecommerce.product.dto.ProductResponse;
import com.aman.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return productService.getProducts(page, size);
    }
}