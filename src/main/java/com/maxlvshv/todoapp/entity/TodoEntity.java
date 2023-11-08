package com.maxlvshv.todoapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Todo")
@Data
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Boolean status;
}
