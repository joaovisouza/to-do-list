package com.meuapp.todolist.controller;

import com.meuapp.todolist.dto.TarefaDTO;
import com.meuapp.todolist.model.Tarefa;
import com.meuapp.todolist.repository.TarefaRepository;
import com.meuapp.todolist.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
@Tag(name = "Tarefas", description = "Endpoints para gerenciamento de tarefas") // Define uma 'seção' no Swagger
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping
    @Operation(summary = "Listar todas tarefas", description = "Retorna uma lista de todas as tarefas cadastradas.")
    public List<Tarefa> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma tarefa por ID", description = "Retorna uma tarefa específica através do seu ID.")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar uma nova tarefa", description = "Cria uma nova tarefa e retorna ela com ID gerado.")
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody TarefaDTO dto) {
        Tarefa novaTarefa = service.salvar(dto);
        System.out.println("Salvando tarefa");
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma tarefa", description = "Remove uma tarefa do sistema pelo seu ID.")
    public void deletarTarefa(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma tarefa existente", description = "Atualiza uma tarefa existente passando o ID e os novos dados.")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id,@Valid @RequestBody TarefaDTO dto) {

        Tarefa tarefaAtualizada = service.atualizar(id, dto);
      //  return ResponseEntity.ok(service.atualizar(id, dto));
        return ResponseEntity.ok(tarefaAtualizada);
    }






}
