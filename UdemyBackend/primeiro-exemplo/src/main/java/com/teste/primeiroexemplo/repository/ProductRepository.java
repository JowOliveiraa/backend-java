package com.teste.primeiroexemplo.repository;

import com.teste.primeiroexemplo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
