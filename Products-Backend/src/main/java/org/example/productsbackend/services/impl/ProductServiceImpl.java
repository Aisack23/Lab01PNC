package org.example.productsbackend.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.productsbackend.domain.dto.request.UpdateProductRequest;
import org.example.productsbackend.domain.dto.response.product.ProductResponse;
import org.example.productsbackend.domain.entities.Product;
import org.example.productsbackend.exceptions.ResourceNotFoundException;
import org.example.productsbackend.repositories.ProductRepository;
import org.example.productsbackend.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void updateProduct(UUID id, Product product) {
        Product existProduct = this.getProductById(id);
        existProduct.setName(product.getName());
        existProduct.setCategory(product.getCategory());
        existProduct.setPrice(product.getPrice());
        existProduct.setAvailable(product.getAvailable());
        productRepository.save(existProduct);
    }

    @Override
    public Product deleteProduct(UUID id) {
        Product existProduct = productRepository.findProductById(id);
        productRepository.deleteById(id);
        return existProduct;
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        return productMapper.toDto(productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"))
        );
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(UUID id, UpdateProductRequest product) {
        this.getProductById(id);
        return productMapper.toDto(productRepository.save(productMapper.toEntityUpdate(product, id)));
    }

    @Override
    public ProductResponse deleteProduct(UUID id) {
        ProductResponse existProduct = this.getProductById(id);
        productRepository.deleteById(id);
        return existProduct;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

}
