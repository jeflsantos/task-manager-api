package com.jefferson.taskmanager.service;

import com.jefferson.taskmanager.dto.TaskRequest;
import com.jefferson.taskmanager.model.Task;
import com.jefferson.taskmanager.model.TaskStatus;
import com.jefferson.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

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

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
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
