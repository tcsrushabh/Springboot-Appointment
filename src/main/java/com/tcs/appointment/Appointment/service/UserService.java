package com.tcs.appointment.Appointment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.appointment.Appointment.User;
import com.tcs.appointment.Appointment.repository.UserRepository;


@Service
public class UserService{

	@Autowired
	UserRepository userRepo;

	
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	
	public Iterable<User> getAll() {
	return userRepo.findAll();
	}

	
}
