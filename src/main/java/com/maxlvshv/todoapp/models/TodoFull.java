package com.maxlvshv.todoapp.models;

import com.maxlvshv.todoapp.entity.TodoEntity;
import lombok.Data;

@Data
public class TodoFull {
    private Long id;

    private String title;

    private String description;

    public static TodoFull toModel(TodoEntity todoEntity) {
        TodoFull model = new TodoFull();
        model.setId(todoEntity.getId());
        model.setTitle(todoEntity.getTitle());
        model.setDescription(todoEntity.getDescription());
        return model;
    }

    @Override
    public String toString() {
        return title + " Description: " + description;
    }
}

