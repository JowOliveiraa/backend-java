package com.meuprojeto.Api.controller;

import com.meuprojeto.Api.dto.UserDTO;
import com.meuprojeto.Api.models.User;
import com.meuprojeto.Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserService service;

    @GetMapping
    public Page<User> list(@PageableDefault(page = 0, size = 5, sort = "name")Pageable pageable) {
        return service.list(pageable);
    }

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody User user) {
        return service.save(user);
    }
}
