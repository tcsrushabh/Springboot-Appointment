package com.tcs.appointment.Appointment;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentrepository ;
	
	@Autowired
	UserRepository userrepository;
	
	public void saveappointment(Appointment app,Integer id) {
		Optional<User> user = userrepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("user does not exist");
		}
		Set<Appointment> appointmentForUser = new HashSet<>();
		appointmentForUser.add(app);
		user.get().setAppointments(appointmentForUser);
		appointmentrepository.save(app);
		System.out.println("Saved");
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

