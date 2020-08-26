package com.codetest.todolist.controller;

import com.codetest.todolist.model.Todo;
import com.codetest.todolist.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Todo> todo(){
		return (Collection<Todo>) this.todoService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Optional<Todo> getTodoById(@PathVariable("id") Long id){
		return todoService.getTodoById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveTodo(@RequestBody @Valid Todo todo){
		todoService.addTodo(todo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void deleteTodo(@PathVariable("id") Long id){
		todoService.deleteTodo(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public void editTodo(@RequestBody @Valid Todo editedTodo ,@PathVariable("id") Long id){
		editedTodo.setId(id);
		todoService.addTodo(editedTodo);
	}
}
