package com.example.TaskManager.controllers;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/tasks")
    Task save(Task task) {
        return taskService.save(task);
    }

    @GetMapping(path = "/tasks")
    List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping(path = "/tasks/{taskId}")
    Task findById(@PathVariable String taskId) {
        return taskService.findById(taskId);
    }

    @DeleteMapping(path = "/tasks/{taskId}")
    void deleteById(@PathVariable String taskId) {
        taskService.deleteById(taskId);
    }
}
