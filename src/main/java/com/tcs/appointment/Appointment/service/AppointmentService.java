package com.tcs.appointment.Appointment.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.appointment.Appointment.Appointment;
import com.tcs.appointment.Appointment.User;
import com.tcs.appointment.Appointment.exception.UserNotFoundException;
import com.tcs.appointment.Appointment.repository.AppointmentRepository;
import com.tcs.appointment.Appointment.repository.UserRepository;


@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentrepository ;
	
	@Autowired
	UserRepository userRepo;
	
	public void save(Appointment app,Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		Set<Appointment> appointmentForUser = new HashSet<>();
		appointmentForUser.add(app);
		user.get().setAppointments(appointmentForUser);
		appointmentrepository.save(app);
		System.out.println("saved");
	}
	
	public Optional<Appointment> getAppointmentDetailsById(Integer id) {
		Optional<Appointment> app = appointmentrepository.findById(id);
		return app;
		
	}
	
	public Iterable<Appointment> deletebyid(Integer id){
		appointmentrepository.deleteById(id);
		return appointmentrepository.findAll();
	}

	public Appointment updateuser(Integer id, Appointment app) {
			Optional<Appointment> userFromDB = appointmentrepository.findById(id);
			Appointment user1 = userFromDB.get();
			if (StringUtils.hasText(app.getUser_name()))
				user1.setUser_name(app.getUser_name());
			if(StringUtils.hasText(app.getUser_email()))
				user1.setUser_email(app.getUser_email());
			if(StringUtils.hasText(app.getTrainerpreference()))
				user1.setTrainerpreference(app.getTrainerpreference());
			if(app.getNoofweeks() != null)
				user1.setNoofweeks(app.getNoofweeks());
			if(app.getPacakageselected() != null)
				user1.setPacakageselected(app.getPacakageselected());
			appointmentrepository.save(user1);
			return user1;
		}

		
	}

