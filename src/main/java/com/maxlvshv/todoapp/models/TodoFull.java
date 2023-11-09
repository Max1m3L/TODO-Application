package com.maxlvshv.todoapp.models;

import com.maxlvshv.todoapp.entity.TodoEntity;
import lombok.Data;

@Data
public class TodoFull {
    private Long id;

    private String title;

    private String description;

    private Boolean status;

    public static TodoFull toModel(TodoEntity todoEntity) {
        TodoFull model = new TodoFull();
        model.setId(todoEntity.getId());
        model.setTitle(todoEntity.getTitle());
        model.setDescription(todoEntity.getDescription());
        model.setStatus(todoEntity.getStatus());
        return model;
    }

    @Override
    public String toString() {
        String complete = "Not done";
        if (status)
            complete = "Done";
        return title + " - status: " + complete + "\nDescription: " + description;
    }
}

