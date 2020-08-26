package com.codetest.todolist.service;

import com.codetest.todolist.model.Todo;
import com.codetest.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Optional<Todo> getTodoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public Todo updateTodo(Todo todo) {
		todoRepository.save(todo);
		return todo;
	}

	@Override
	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo deleteTodo(long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		todo.ifPresent(value -> todoRepository.delete(value));
        return null;
    }
}