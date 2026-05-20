package org.example.productsbackend.domain.dto.response.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String name;
    private Double price;
    private Boolean available;
}