package com.tracker.dailyTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.dailyTracker.entities.Task;
import com.tracker.dailyTracker.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
    private TaskRepository taskRepo;

    public List<Task> getTasks(String username) {
        return taskRepo.findByUsername(username);
    }

    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepo.findById(id).orElseThrow();
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        task.setTags(updatedTask.getTags());
        return taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    // Additional filters
    public List<Task> filterByStatus(String username, String status) {
        return taskRepo.findByUsernameAndStatus(username, status);
    }

    public List<Task> searchByTitle(String username, String keyword) {
        return taskRepo.findByUsernameAndTitleContainingIgnoreCase(username, keyword);
    }
}
