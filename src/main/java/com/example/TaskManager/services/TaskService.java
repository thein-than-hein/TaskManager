package com.example.TaskManager.services;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String taskId) throws NoSuchElementException {
        Optional<Task> task = taskRepository.findById(Integer.valueOf(taskId));
        if (task.isPresent()) return task.get();
        throw new NoSuchElementException();
    }

    public void deleteById(String taskId) {
        taskRepository.deleteById(Integer.valueOf(taskId));
    }
}
