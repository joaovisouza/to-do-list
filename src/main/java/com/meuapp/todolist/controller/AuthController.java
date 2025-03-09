package com.meuapp.todolist.controller;

import com.meuapp.todolist.dto.LoginRequestDTO;
import com.meuapp.todolist.dto.TokenResponseDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/auth")
public class AuthController {

        private static final String SECRET_KEY = "minha-chave-secreta";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO login) {
        if ("admin".equals(login.getLogin()) && "1234".equals(login.getSenha())) {
            String token = gerarToken(login.getLogin());
            return ResponseEntity.ok(new TokenResponseDTO(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }

    private String gerarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
