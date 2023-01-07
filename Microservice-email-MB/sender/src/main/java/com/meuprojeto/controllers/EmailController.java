package com.meuprojeto.controllers;

import com.meuprojeto.dtos.EmailDTO;
import com.meuprojeto.models.Email;
import com.meuprojeto.repositories.EmailRepository;
import com.meuprojeto.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class EmailController {

    @Autowired
    private EmailService service;

    @Autowired
    private EmailRepository repository;

    @GetMapping
    public String f(){
        return "Funfa";
    }

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO dto) {
        Email email = new Email(dto);

        service.sendEmail(email);

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
