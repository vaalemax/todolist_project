package org.example.progetto_todolist.repository;

import org.example.progetto_todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t ORDER BY t.toggle ASC, t.title ASC")
    List<Todo> findAllOrdered();
}
