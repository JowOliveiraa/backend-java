package io.example.authapi.services;

import io.example.authapi.models.daos.TokenDAO;
import io.example.authapi.models.daos.UserDAO;
import io.example.authapi.models.dtos.AuthenticationDTO;
import io.example.authapi.models.dtos.RegisterDTO;
import io.example.authapi.models.entities.User;
import io.example.authapi.repositories.UserRepository;
import io.example.authapi.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email);
    }

    public ResponseEntity<Object> login(@RequestBody AuthenticationDTO dto) {
        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDAO(token));
    }

    public ResponseEntity<Object> register(@RequestBody RegisterDTO dto) {
        if (this.repository.findByEmail(dto.email()) != null) {
            return ResponseEntity.badRequest().body("Email ja cadastrado no sistema!");
        }
        var user = new User(dto);
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        user.updatePassword(encryptedPassword);
        this.repository.save(user);

        return ResponseEntity.accepted().body(new UserDAO(user));

    }
}
