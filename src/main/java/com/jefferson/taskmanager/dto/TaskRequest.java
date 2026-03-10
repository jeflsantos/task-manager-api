package com.jefferson.taskmanager.dto;


import jakarta.validation.constraints.NotBlank;

public class TaskRequest {

    @NotBlank(message = "Title é obrigatório")
    private String title;
    @NotBlank(message = "Description é obrigatório")
    private String description;
    @NotBlank(message = "Assignee é obrigatório")
    private String assignee;

    public String getTitle (){
        return title;
    }
    public void setTitle(String title){
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
}
