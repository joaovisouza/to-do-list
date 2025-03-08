package com.meuapp.todolist.controller;

import com.meuapp.todolist.dto.LoginRequestDTO;
import com.meuapp.todolist.dto.TokenResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO login) {
        // Aqui você valida usuário/senha e gera token JWT
        String token = "mocked-jwt-token";
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }
}
