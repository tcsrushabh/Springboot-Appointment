package com.tcs.appointment.Appointment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentrepository ;
	
	public void saveappointment(Appointment app) {
		appointmentrepository.save(app);
		System.out.println("Called");
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

