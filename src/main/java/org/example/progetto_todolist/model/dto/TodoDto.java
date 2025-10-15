package org.example.progetto_todolist.model.dto;

import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private String title;
    private boolean toggle;
    private boolean delete;
    //private int toDoListId;
}
