package com.meuapp.todolist.repository;

import com.meuapp.todolist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
