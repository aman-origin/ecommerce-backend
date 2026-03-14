package com.aman.ecommerce.product.service;

import com.aman.ecommerce.product.dto.CreateProductRequest;
import com.aman.ecommerce.product.dto.ProductResponse;
import com.aman.ecommerce.product.entity.Category;
import com.aman.ecommerce.product.entity.Product;
import com.aman.ecommerce.product.repository.CategoryRepository;
import com.aman.ecommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(category)
                .build();

        Product saved = productRepository.save(product);

        return ProductResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .price(saved.getPrice())
                .stock(saved.getStock())
                .category(saved.getCategory().getName())
                .build();
    }

    @Override
    public Page<ProductResponse> getProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        return productRepository.findAll(pageable)
                .map(product -> ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .stock(product.getStock())
                        .category(product.getCategory().getName())
                        .build());
    }
}