package com.jefferson.taskmanager.service;

import com.jefferson.taskmanager.model.Task;
import com.jefferson.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void creatTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

}
