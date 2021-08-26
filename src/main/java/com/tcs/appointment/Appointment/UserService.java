package com.tcs.appointment.Appointment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;



public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	public void saveuser(User user) {
		userrepository.save(user);
		System.out.println("Called");
	}
	

}
