package org.example.progetto_todolist.mapper;

import org.example.progetto_todolist.model.Todo;
import org.example.progetto_todolist.model.dto.TodoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo toEntity(TodoDto dto);

    TodoDto toDto(Todo entity);
}
