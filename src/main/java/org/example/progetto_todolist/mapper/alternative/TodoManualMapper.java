package org.example.progetto_todolist.mapper.alternative;

import org.example.progetto_todolist.model.Todo;
import org.example.progetto_todolist.model.dto.TodoDto;

public interface TodoManualMapper {
    default Todo toEntity(TodoDto dto){
        Todo entity = new Todo();
        entity.setTitle(dto.getTitle());
        entity.setDelete(dto.isDelete());
        entity.setToggle(dto.isToggle());
        entity.setId(dto.getId());
        return entity;
    }
    default TodoDto toDto(Todo entity){
        TodoDto dto = new TodoDto();
        dto.setTitle(entity.getTitle());
        dto.setToggle(entity.isToggle());
        dto.setDelete(entity.isDelete());
        dto.setId(entity.getId());
        return dto;
    }
}
