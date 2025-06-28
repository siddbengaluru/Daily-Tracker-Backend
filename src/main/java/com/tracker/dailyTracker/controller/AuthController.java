package com.tracker.dailyTracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dailyTracker.entities.User;
import com.tracker.dailyTracker.repositories.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	 @Autowired
	 private UserRepository userRepository;
	 
	 @PostMapping("/login")
	  public ResponseEntity<?> login(@RequestBody User loginRequest) {
	        Optional<User> userOpt = userRepository.findByUsername(loginRequest.getUsername());

	        if (userOpt.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
	        }

	        User user = userOpt.get();

	        if (!user.getPassword().equals(loginRequest.getPassword())) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
	        }

	        return ResponseEntity.ok("Login successful");
	    }
}
