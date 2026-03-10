package com.jefferson.taskmanager.controller;

import com.jefferson.taskmanager.dto.TaskRequest;
import com.jefferson.taskmanager.dto.TaskResponse;
import com.jefferson.taskmanager.model.Task;
import com.jefferson.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public String createTask(@RequestBody TaskRequest request){

        taskService.createTask(request);
        return "Tarefa criada com Sucesso!";
    }

    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);

        if (task == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
