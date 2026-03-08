package com.jefferson.taskmanager.repository;

import com.jefferson.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
