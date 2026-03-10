package com.jefferson.taskmanager.dto;

import com.jefferson.taskmanager.model.TaskStatus;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private String assignee;
    private TaskStatus status;

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getAssignee(){
        return assignee;
    }
    public TaskStatus getStatus(){
        return status;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setAssignee(String assignee){
        this.assignee = assignee;
    }
    public void setStatus(TaskStatus status){
        this.status = status;
    }

}
