package com.tcs.appointment.Appointment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
