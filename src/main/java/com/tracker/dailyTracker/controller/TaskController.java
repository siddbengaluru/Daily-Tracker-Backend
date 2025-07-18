package com.tracker.dailyTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dailyTracker.entities.Task;
import com.tracker.dailyTracker.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
	
	@Autowired
    private TaskService taskService;

    @GetMapping("/{username}")
    public List<Task> getAllTasks(@PathVariable String username) {
        return taskService.getTasks(username);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/{username}/search")
    public List<Task> searchTasks(@PathVariable String username, @RequestParam String keyword) {
        return taskService.searchByTitle(username, keyword);
    }

    @GetMapping("/{username}/status")
    public List<Task> filterByStatus(@PathVariable String username, @RequestParam String status) {
        return taskService.filterByStatus(username, status);
    }
}
