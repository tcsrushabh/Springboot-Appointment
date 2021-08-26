package com.tcs.appointment.Appointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;
	
	@NotEmpty(message="Enter name")
	@Size(min=2 , message = "Enter valid name")
	private String user_name;
	
	@NotNull(message="Mobile number should  not be null")
	private long user_mobno;
	
	@NotEmpty(message = "Enter Email")
	@Email(message = "Enter valid mail")
	private String user_email;
	
	@NotEmpty (message = "Enter Trainer prefernece")
	private String trainerpreference;
	
	@NotNull(message="Enter weeks")
	@Min(1)
	private Integer noofweeks;
	
	@Min(300)
	@Max(500)
	private Integer pacakageselected;
	
	@Value("${some.key:false}")
	private boolean physiorequired;
	
	private int amount= pacakageselected*noofweeks;
	
	@ManyToOne
    private User user;
	
}

