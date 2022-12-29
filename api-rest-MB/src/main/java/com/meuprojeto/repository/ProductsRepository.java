package com.meuprojeto.repository;

import com.meuprojeto.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    Product findById(long id);
}
