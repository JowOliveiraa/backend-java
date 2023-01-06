package com.teste.primeiroexemplo.controller;

import com.teste.primeiroexemplo.dto.ProductUpdateDTO;
import com.teste.primeiroexemplo.models.Product;
import com.teste.primeiroexemplo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Page<Product> list(@PageableDefault(size = 5) Pageable page) {
        return service.serviceFindAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>detail(@PathVariable Long id) {
        return service.serviceFindById(id);
    }

    @PostMapping
    public Product register(@RequestBody Product product){
        return service.serviceSave(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>update(@PathVariable Long id, @RequestBody ProductUpdateDTO dto) {
        return service.serviceUpdate(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > delete(@PathVariable Long id) {
        return service.serviceDelete(id);
    }
}
