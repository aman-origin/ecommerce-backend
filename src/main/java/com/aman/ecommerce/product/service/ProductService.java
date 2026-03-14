package com.aman.ecommerce.product.service;

import com.aman.ecommerce.product.dto.CreateProductRequest;
import com.aman.ecommerce.product.dto.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest request);

    Page<ProductResponse> getProducts(int page, int size);

}