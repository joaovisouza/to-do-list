package com.meuapp.todolist.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API TodoList - Gerenciamento de Tarefas")
                        .version("1.0")
                        .description("Documentação da API de Tarefas, com todos os endpoints e exemplos de uso.")
                        .contact(new Contact()
                                .name("João Victor")
                                .email("joao200203@gmail.com")));
    }
}

