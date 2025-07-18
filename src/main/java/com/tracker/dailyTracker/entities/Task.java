package com.tracker.dailyTracker.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Task")
public class Task {
	
	@Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;
    private String tags;
    private String username;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate date) {
		this.dueDate = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	


	public Task(Long id, String title, String description, LocalDate date, String status, String tags,
			String username) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = date;
		this.status = status;
		this.tags = tags;
		this.username = username;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", date=" + dueDate + ", status="
				+ status + ", tags=" + tags + ", username=" + username + "]";
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
