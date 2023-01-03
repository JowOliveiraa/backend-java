package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.domain.user.AuthenticationRecordData;
import med.vol.api.domain.user.User;
import med.vol.api.infra.security.TokenRecordData;
import med.vol.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationRecordData data) {
        var userToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var authentication = manager.authenticate(userToken);

        var token = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().body(new TokenRecordData(token));
    }
}
