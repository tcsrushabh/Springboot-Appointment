package com.tcs.appointment.Appointment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/user")
	public void save(@Valid @RequestBody User user) {
		userservice.saveuser(user);
	}
}
