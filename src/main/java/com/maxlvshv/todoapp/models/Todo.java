package com.maxlvshv.todoapp.models;

import com.maxlvshv.todoapp.entity.TodoEntity;
import lombok.Data;

@Data
public class Todo {
    private Long id;

    private String title;

    private String description;

    public static Todo toModel(TodoEntity todoEntity) {
        Todo model = new Todo();
        model.setId(todoEntity.getId());
        model.setTitle(todoEntity.getTitle());
        model.setDescription(todoEntity.getDescription());
        return model;
    }

    @Override
    public String toString() {
        return title;
    }
}
