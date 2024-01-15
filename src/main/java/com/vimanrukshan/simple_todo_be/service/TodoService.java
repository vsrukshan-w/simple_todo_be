package com.vimanrukshan.simple_todo_be.service;

import com.vimanrukshan.simple_todo_be.model.Todo;
import com.vimanrukshan.simple_todo_be.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {


    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo existingTodo = optionalTodo.get();
            existingTodo.setText(updatedTodo.getText());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existingTodo);
        } else {
            throw new IllegalArgumentException("Todo not found with id: " + id);
        }
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
