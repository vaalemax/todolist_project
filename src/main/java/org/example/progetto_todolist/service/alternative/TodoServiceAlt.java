package org.example.progetto_todolist.service.alternative;

import org.example.progetto_todolist.mapper.alternative.TodoManualMapper;
import org.example.progetto_todolist.model.Todo;
import org.example.progetto_todolist.model.dto.TodoDto;
import org.example.progetto_todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceAlt implements TodoManualMapper{

    private final TodoRepository repository;


    public void addTodo(TodoDto body){
        System.out.println(body+ "   "+ body.getTitle());
        Todo entity = toEntity(body);
        System.out.println(entity+ "   "+ entity.getTitle());
        repository.save(entity);
        System.out.println(entity+ "   "+ entity.getTitle());
    }

    public TodoDto updateTitle(Long id, TodoDto body) throws Exception {
        Todo dto = repository.findById(id)
                .orElseThrow(()-> new Exception("Todo non trovato"));
        dto.setTitle(body.getTitle());

        repository.save(dto);
        return toDto(dto);
    }

    public TodoDto updateToggle(Long id) throws Exception {
        Todo dto = repository.findById(id)
                .orElseThrow(()-> new Exception("Todo non trovato"));

        dto.setToggle(!dto.isToggle());

        repository.save(dto);
        return toDto(dto);
    }

    public TodoDto updateDelete(Long id) throws Exception {
        Todo dto = repository.findById(id)
                .orElseThrow(()-> new Exception("Todo non trovato"));

        if(!dto.isDelete()){
            dto.setDelete(true);
        }
        repository.save(dto);
        return toDto(dto);
    }

    public TodoDto findTodo(Long id) throws Exception{
        Todo entity = repository.findById(id).orElseThrow(()-> new Exception("Todo non trovato"));
        return toDto(entity);
    }

    public List<TodoDto> findAllTodo(){
        List<Todo> entities = repository.findAll();
        List<TodoDto> dtos = new ArrayList<>();
        for(Todo entity : entities){
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}
