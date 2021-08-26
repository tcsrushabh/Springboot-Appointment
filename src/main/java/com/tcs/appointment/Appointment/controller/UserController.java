package com.tcs.appointment.Appointment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.appointment.Appointment.User;
import com.tcs.appointment.Appointment.service.UserService;


@RestController
@ControllerAdvice
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User savedUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);	
	}
	@GetMapping("/user")
	public Iterable<User> getAllUser() {
		return userService.getAll();
	}
}