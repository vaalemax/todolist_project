package org.example.progetto_todolist.controller;

import org.example.progetto_todolist.model.dto.TodoForm;
import org.example.progetto_todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping("/")
    public String create(@ModelAttribute("todoForm") TodoForm body){
        service.addTodo(body.getTitle());
        return "redirect:/";
    }

    @PatchMapping("/title/{id}")
    public String updateTitle(@PathVariable Long id,@RequestParam String title) throws Exception {
        service.updateTitle(id, title);
        return "redirect:/";
    }

    @PatchMapping("/toggle/{id}")
    public String updateToggle(@PathVariable Long id) throws Exception {
        service.updateToggle(id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String updateDelete(@PathVariable Long id) throws Exception {
        service.updateDelete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) throws Exception {
        service.findTodo(id);
        return "template";
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("todos", service.findAllTodo());
        model.addAttribute("todoForm", new TodoForm());
        return "template";
    }
}
