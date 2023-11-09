package com.maxlvshv.todoapp.controllers;

import com.maxlvshv.todoapp.entity.TodoEntity;
import com.maxlvshv.todoapp.exeptions.TheSameTodoAlreadyExistExeption;
import com.maxlvshv.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class TodoController {
    public final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getAll(Model model, TodoEntity entity) {
        model.addAttribute("todoList", todoService.showAll());
        model.addAttribute("Entity", entity);
        return "index";
    }

    @GetMapping("/{title}")
    public String getOne(@PathVariable("title") String title, Model model) {
        model.addAttribute("todo", todoService.showOne(title));
        return "aTodo";
    }

    @GetMapping("/new")
    public String newTodo(Model model) {
        model.addAttribute("todo", new TodoEntity());
        return "new";
    }

    @PostMapping
    public String createTodo(@ModelAttribute TodoEntity todo) throws TheSameTodoAlreadyExistExeption {
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable long id) {
        todoService.delete(id);
        return "redirect:/";
    }
}
