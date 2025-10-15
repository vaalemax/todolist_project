package org.example.progetto_todolist.model.dto;

import lombok.Data;

@Data
public class TodoForm {
    private Long id;
    private String title;
    private boolean toggle = false;
    private boolean delete = false;
}
