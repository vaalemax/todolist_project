package org.example.progetto_todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name="todo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLRestriction("delete = false")


public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="toggle", columnDefinition="boolean default false")
    private boolean toggle;

    @Column(name="delete", columnDefinition="boolean default false")
    private boolean delete;
/*
    @ManyToOne
    @JoinColumn(name = "todolist")
    private TDList toDoList;*/
}
