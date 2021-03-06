package com.tcs.appointment.Appointment.controller;

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

import com.tcs.appointment.Appointment.Appointment;
import com.tcs.appointment.Appointment.exception.UserNotFoundException;
import com.tcs.appointment.Appointment.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentservice ;
	
	@PostMapping("/placeappointment/{id}")
	public ResponseEntity<Appointment> save(@PathVariable Integer id ,@Valid @RequestBody Appointment app) {
		app.setAmount(app.getNoofweeks()*app.getPacakageselected());
		appointmentservice.save(app,id);
		return new ResponseEntity<Appointment>(app,HttpStatus.OK);
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
	@ExceptionHandler(value =  { UserNotFoundException.class})
	public ResponseEntity<Appointment> exception(Exception userNotFoundException) {
	    return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	}	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
	    return new ResponseEntity<>("Error : " + e.toString(), HttpStatus.BAD_REQUEST);
	}
}
