package com.vueloscolombia.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import com.vueloscolombia.backend.dto.LoginRequest;
import com.vueloscolombia.backend.dto.LoginResponse;
import com.vueloscolombia.backend.service.AuthService;
import com.vueloscolombia.backend.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody LoginRequest req) {
        authService.register(req.getUsername(), req.getPassword());
        return "Registrado";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    req.getUsername(),
                    req.getPassword()
                )
            );

            String token = jwtUtil.generateToken(req.getUsername());
            return new LoginResponse(token);

        } catch (AuthenticationException ex) {
            throw new RuntimeException("Credenciales invalidas");
        }
    }
}
