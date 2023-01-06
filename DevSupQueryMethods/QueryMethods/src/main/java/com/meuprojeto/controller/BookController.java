package com.meuprojeto.controller;

import com.meuprojeto.models.Book;
import com.meuprojeto.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<Page<Book>> list(@PageableDefault(size = 5)Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/byName")
    public ResponseEntity<Page<Book>> orderByName(@PageableDefault(size = 5) Pageable pageable) {
        return service.orderByName(pageable);
    }
}
