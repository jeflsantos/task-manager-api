package com.jefferson.taskmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String  assignee;
    private LocalDate startDate;
    private LocalDate dueDate;
    private TaskStatus status;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle (String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getAssignee(){
        return assignee;
    }
    public void setAssignee(String assignee){
        this.assignee = assignee;
    }

    public LocalDate getStartDate(){
        return startDate;
    }
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus(){
        return status;
    }
    public void setStatus(TaskStatus status){
        this.status = status;
    }
}
