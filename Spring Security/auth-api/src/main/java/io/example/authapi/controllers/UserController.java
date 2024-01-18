package io.example.authapi.controllers;

import io.example.authapi.models.dtos.AuthenticationDTO;
import io.example.authapi.models.dtos.RegisterDTO;
import io.example.authapi.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationDTO dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO dto) {
        return service.register(dto);
    }
}
