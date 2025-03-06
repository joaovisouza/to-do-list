package com.meuapp.todolist.service;

import com.meuapp.todolist.dto.TarefaDTO;
import com.meuapp.todolist.model.Tarefa;
import com.meuapp.todolist.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;


    public List<Tarefa> listarTodas () {
        return repository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa com id igual a " + id + " não encontrada!"));
    }

    public Tarefa salvar(TarefaDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setConcluida(dto.isConcluida());

        return repository.save(tarefa);
    }

    public void deletar(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Tarefa com id igual a " + id + " não encontrada!");
        }
        repository.deleteById(id);
    }
    public Tarefa atualizar(Long id, TarefaDTO dto){
         Tarefa tarefa = repository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

         tarefa.setTitulo(dto.getTitulo());
         tarefa.setDescricao(dto.getDescricao());
         tarefa.setConcluida(dto.isConcluida());

         return repository.save(tarefa);
    }


}
