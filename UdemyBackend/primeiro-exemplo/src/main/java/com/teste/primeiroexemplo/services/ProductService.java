package com.teste.primeiroexemplo.services;

import com.teste.primeiroexemplo.models.Product;
import com.teste.primeiroexemplo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    public Page<Product> serviceFindAll(Pageable page) {
        return repository.findAll(page);
    }

    @Transactional
    public Product serviceSave(Product product) {
        return repository.save(product);
    }

    public ResponseEntity<Object> serviceFindById(Long id) {
        if (repository.existsById(id)) {
            var product = repository.getReferenceById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(product));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe na nossa base");
    }

    @Transactional
    public ResponseEntity<Object> serviceUpdate(Long id, Product dto) {
        if (repository.existsById(id)) {
            var product = repository.getReferenceById(id);
            product.productUpdate(dto);
            return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(product));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe na nossa base");
    }

    @Transactional
    public ResponseEntity<String> serviceDelete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe na base");
    }
}
