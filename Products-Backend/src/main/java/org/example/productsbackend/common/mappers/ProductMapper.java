package org.example.productsbackend.common.mappers;

import org.example.productsbackend.domain.dto.request.CreateProductRequest;
import org.example.productsbackend.domain.dto.request.UpdateProductRequest;
import org.example.productsbackend.domain.dto.response.product.ProductResponse;
import org.example.productsbackend.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductMapper {
    public Product toEntityCreate(CreateProductRequest createProductRequest) {
        return Product.builder()
                .name(createProductRequest.getName())
                .category(createProductRequest.getCategory())
                .price(createProductRequest.getPrice())
                .available(createProductRequest.getAvailable())
                .build();
    }

    public ProductResponse toDto(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .available(product.getAvailable())
                .build();
    }

    public Product toEntityUpdate(UpdateProductRequest updateProductRequest, UUID id) {
        return Product.builder()
                .id(id)
                .name(updateProductRequest.getName())
                .category(updateProductRequest.getCategory())
                .price(updateProductRequest.getPrice())
                .available(updateProductRequest.getAvailable())
                .build();
    }
    public List<ProductResponse> toDtoList(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .toList();
    }



}