package com.codetest.todolist.repository;

import com.codetest.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	Optional<Todo> findById(long id);
}
