package com.jefferson.taskmanager.service;

import com.jefferson.taskmanager.dto.TaskRequest;
import com.jefferson.taskmanager.dto.TaskResponse;
import com.jefferson.taskmanager.exception.TaskNotFoundException;
import com.jefferson.taskmanager.model.Task;
import com.jefferson.taskmanager.model.TaskStatus;
import com.jefferson.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskRequest request) {
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setAssignee(request.getAssignee());

        task.setStatus(TaskStatus.PENDING);

        taskRepository.save(task);

    }

    public List<TaskResponse> getAllTasks(){

        List<Task> tasks = taskRepository.findAll();

        List<TaskResponse> responseList = new ArrayList<>();

        for (Task task : tasks){
            TaskResponse response = new TaskResponse();

            response.setId(task.getId());
            response.setTitle(task.getTitle());
            response.setDescription(task.getDescription());
            response.setAssignee(task.getAssignee());
            response.setStatus(task.getStatus());

            responseList.add(response);
        }

        return responseList;
    }

    public TaskResponse getTaskById(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        TaskResponse response = new TaskResponse();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setAssignee(task.getAssignee());
        response.setStatus(task.getStatus());

        return response;
    }

    public Task updateTask(Long id, Task updatedTask){
        Task task = taskRepository.findById(id).orElse(null);

        if (task != null){
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setAssignee(updatedTask.getAssignee());
            task.setStartDate(updatedTask.getStartDate());
            task.setDueDate(updatedTask.getDueDate());
            task.setStatus(updatedTask.getStatus());

            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
