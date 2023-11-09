package com.maxlvshv.todoapp.models;

import com.maxlvshv.todoapp.entity.TodoEntity;
import lombok.Data;

@Data
public class Todo {
    private String title;

    private String description;

    private Boolean status;


    public static Todo toModel(TodoEntity todoEntity) {
        Todo model = new Todo();
        model.setTitle(todoEntity.getTitle());
        model.setDescription(todoEntity.getDescription());
        model.setStatus(todoEntity.getStatus());
        return model;
    }

    public void setStatusTrue() {
        this.status = true;
    }

    @Override
    public String toString() {
        String complete = "Not done";
        if (status)
            complete = "Done";
        return title + " - status: " + complete;
    }
}
