package com.teste.primeiroexemplo.dto;

import com.teste.primeiroexemplo.models.Product;

public record ProductDTO(
        Long id,
        String name,
        int quantity,
        double price,
        String observation)
{
    public ProductDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice(),
                product.getObservation());
    }
}
