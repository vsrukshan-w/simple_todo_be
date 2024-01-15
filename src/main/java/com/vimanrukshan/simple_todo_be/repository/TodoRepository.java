package com.vimanrukshan.simple_todo_be.repository;

import com.vimanrukshan.simple_todo_be.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
