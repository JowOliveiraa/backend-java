package com.meuprojeto.controller;

import com.meuprojeto.models.Product;
import com.meuprojeto.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductsRepository repository;

    @GetMapping
    public List<Product> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return repository.findById(id);
    }

    @PostMapping
    @Transactional
    public void register(@RequestBody Product data) {
        repository.save(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping
    @Transactional
    public Product update(@RequestBody Product data) {
        return repository.save(data);
    }

}
