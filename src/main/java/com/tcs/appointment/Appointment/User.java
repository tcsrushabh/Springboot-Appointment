package com.tcs.appointment.Appointment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "first name must not be empty")
	@Size(min=2,message="name should be gretaer the 2 characters")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID")
	private Set<Appointment> appointments;
}
