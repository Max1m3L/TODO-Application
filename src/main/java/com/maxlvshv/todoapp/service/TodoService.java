package com.maxlvshv.todoapp.service;

import com.maxlvshv.todoapp.entity.TodoEntity;
import com.maxlvshv.todoapp.exeptions.TheSameTodoAlreadyExistExeption;
import com.maxlvshv.todoapp.models.Todo;
import com.maxlvshv.todoapp.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepo todoRepo;

    @Autowired
    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> showAll() {
        List<TodoEntity> todoEntityList = todoRepo.findAll();
        List<Todo> todoList = new ArrayList<>();
        for (TodoEntity el : todoEntityList)
            todoList.add(Todo.toModel(el));

        return todoList;
    }

    public Todo showOne(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        return Todo.toModel(todo);
    }

    public void addTodo(TodoEntity todo) throws TheSameTodoAlreadyExistExeption {
        if (todoRepo.findByTitle(todo.getTitle()) != null)
            throw new TheSameTodoAlreadyExistExeption("you added the same todo early");
        todoRepo.save(todo);
    }
}
