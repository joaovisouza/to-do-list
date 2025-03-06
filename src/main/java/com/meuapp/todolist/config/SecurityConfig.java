package com.meuapp.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desativa CSRF só pra facilitar no Postman
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()  // Todas as requisições precisam de login
                )
                .httpBasic(); // Define o tipo de autenticação como Basic Auth


        return http.build();
    }

}
