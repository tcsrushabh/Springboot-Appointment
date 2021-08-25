package com.tcs.appointment.Appointment;



import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentservice ;
	
	@PostMapping("/placeappointment")
	public void placeappointment(@Valid @RequestBody Appointment app) {
		appointmentservice.saveappointment(app);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
	    return new ResponseEntity<>("Error : " + e.toString(), HttpStatus.BAD_REQUEST);
	  }
	
	@GetMapping("/placeappointment/{id}")
	public Appointment getUser(@PathVariable Integer id){
		Optional<Appointment> app1 = appointmentservice.getAppointmentDetailsById(id);
		Appointment appo = app1.get();
		return appo;
	}
		
	@DeleteMapping("/placeappointment/{id}")
	public Iterable<Appointment> deletUser(@PathVariable Integer id) {
		return appointmentservice.deletebyid(id);
	}
	
	@PutMapping("/placeappointment/{id}")
	public Appointment updateuser(@PathVariable Integer id ,@RequestBody Appointment app) {
		return appointmentservice.updateuser(id,app);
	}
		
	
}
