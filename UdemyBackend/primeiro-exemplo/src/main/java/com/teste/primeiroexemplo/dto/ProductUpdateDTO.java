package com.teste.primeiroexemplo.dto;

public record ProductUpdateDTO(
        String name,
        Integer quantity,
        Double price,
        String observation) {}
