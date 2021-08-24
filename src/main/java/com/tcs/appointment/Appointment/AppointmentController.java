package com.tcs.appointment.Appointment;



import java.io.Console;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentservice ;
	
	@PostMapping("/placeappointment")
	public void placeappointment(@RequestBody Appointment app) {
		appointmentservice.saveappointment(app);
	}
	
	@GetMapping("/placeappointment/{id}")
	public Appointment getUser(@PathVariable Integer id){
		Optional<Appointment> app1 = appointmentservice.getAppointmentDetailsById(id);
		Appointment appo = app1.get();
		return appo;
		
		
	}
}
