package com.meuprojeto.Api.service;

import com.meuprojeto.Api.dto.UserDTO;
import com.meuprojeto.Api.models.User;
import com.meuprojeto.Api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public ResponseEntity<Object> save(User user) {
       return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getDepartment()));
    }
}
