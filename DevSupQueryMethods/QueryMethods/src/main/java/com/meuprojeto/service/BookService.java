package com.meuprojeto.service;

import com.meuprojeto.models.Book;
import com.meuprojeto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public ResponseEntity<Page<Book>> findAll(Pageable pageable) {
        var result = repository.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public ResponseEntity<Page<Book>> orderByName(Pageable pageable) {
        var result = repository.findByOrderByName(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
