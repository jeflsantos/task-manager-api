package com.jefferson.taskmanager.dto;


public class TaskRequest {

    private String title;
    private String description;
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
