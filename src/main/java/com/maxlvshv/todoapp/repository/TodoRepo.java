package com.maxlvshv.todoapp.repository;

import com.maxlvshv.todoapp.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
    TodoEntity findByTitle(String title);

    void deleteById(long id);

    List<TodoEntity> findAll();
}
