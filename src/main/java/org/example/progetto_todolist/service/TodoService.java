package org.example.progetto_todolist.service;

import org.example.progetto_todolist.mapper.TodoMapper;
import org.example.progetto_todolist.model.Todo;
import org.example.progetto_todolist.model.dto.TodoDto;
import org.example.progetto_todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService{

    private final TodoRepository repository;

    private final TodoMapper mapper;

    public void addTodo(String string){
        Todo entity = new Todo();
        entity.setTitle(string);
        repository.save(entity);
    }

    public TodoDto updateTitle(Long id, String title) throws Exception {
        Todo dto = repository.findById(id)
                .orElseThrow(()-> new Exception("Todo non trovato"));
        dto.setTitle(title);

        repository.save(dto);
        return mapper.toDto(dto);
    }

    public TodoDto updateToggle(Long id) throws Exception {
        Todo dto = repository.findById(id)
                .orElseThrow(()-> new Exception("Todo non trovato"));

        dto.setToggle(!dto.isToggle());

        repository.save(dto);
        return mapper.toDto(dto);
    }

    public TodoDto updateDelete(Long id) throws Exception {
        Todo dto = repository.findById(id)
                .orElseThrow(()-> new Exception("Todo non trovato"));

        if(!dto.isDelete()){
            dto.setDelete(true);
        }
        repository.save(dto);
        return mapper.toDto(dto);
    }

    public TodoDto findTodo(Long id) throws Exception{
        Todo entity = repository.findById(id).orElseThrow(()-> new Exception("Todo non trovato"));
        return mapper.toDto(entity);
    }

    public List<TodoDto> findAllTodo(){
        List<Todo> entities = repository.findAllOrdered();
        List<TodoDto> dtos = new ArrayList<>();
        for(Todo entity : entities){
            dtos.add(mapper.toDto(entity));
        }
        return dtos;
    }

}
