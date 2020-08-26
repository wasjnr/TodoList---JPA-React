package com.codetest.todolist.service;

import com.codetest.todolist.model.Todo;

import java.util.Optional;

public interface ITodoService {

	Optional<Todo> getTodoById(long id);

	Iterable<Todo> findAll();

	Todo updateTodo(Todo todo);

	Todo addTodo(Todo todo);

	Todo deleteTodo(long id);

}