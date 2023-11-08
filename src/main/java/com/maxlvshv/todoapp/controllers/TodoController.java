package com.maxlvshv.todoapp.controllers;

import ch.qos.logback.core.joran.conditional.ThenAction;
import com.maxlvshv.todoapp.entity.TodoEntity;
import com.maxlvshv.todoapp.exeptions.TheSameTodoAlreadyExistExeption;
import com.maxlvshv.todoapp.models.Todo;
import com.maxlvshv.todoapp.repository.TodoRepo;
import com.maxlvshv.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TodoController {
    public final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(todoService.showAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("some errors");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(todoService.showOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't find this todo");
        }
    }

    @PostMapping("/add")
    public ResponseEntity addTodo(@RequestBody TodoEntity todo) {
        try {
            todoService.addTodo(todo);
            return ResponseEntity.ok("todo is add successfully");
        } catch (TheSameTodoAlreadyExistExeption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error while add");
        }
    }
}
