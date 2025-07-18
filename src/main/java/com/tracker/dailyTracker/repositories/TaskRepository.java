package com.tracker.dailyTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.dailyTracker.entities.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	 List<Task> findByUsername(String username);
	 List<Task> findByUsernameAndStatus(String username, String status);
	 List<Task> findByUsernameAndDueDate(String username, LocalDate dueDate);
	 List<Task> findByUsernameAndTitleContainingIgnoreCase(String username, String keyword);

}
