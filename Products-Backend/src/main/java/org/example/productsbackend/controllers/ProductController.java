package org.example.productsbackend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.productsbackend.domain.dto.request.CreateProductRequest;
import org.example.productsbackend.domain.dto.request.UpdateProductRequest;
import org.example.productsbackend.domain.dto.response.GeneralResponse;
import org.example.productsbackend.domain.entities.Product;
import org.example.productsbackend.services.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("/create")
    public ResponseEntity<GeneralResponse> createProduct(@RequestBody CreateProductRequest product) {
        return buildResponse(
                "Product created successfully",
                HttpStatus.CREATED,
                productService.createProduct(product)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralResponse> updateProduct(
            @PathVariable UUID id,
            @RequestBody UpdateProductRequest product
    ) {
        return buildResponse(
                "Product updated successfully",
                HttpStatus.OK,
                productService.updateProduct(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.deleteProduct(id));
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }


}
