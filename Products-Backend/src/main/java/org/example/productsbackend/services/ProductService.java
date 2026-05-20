package org.example.productsbackend.services;

import org.example.productsbackend.domain.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void createProduct(CreateProduct product);
    List<Product> getAllProducts();
    Product getProductById(UUID id);
    void updateProduct(UUID id, Product product);
    Product deleteProduct(UUID id);

}
