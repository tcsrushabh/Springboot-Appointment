package com.tcs.appointment.Appointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

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
	
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public long getUser_mobno() {
		return user_mobno;
	}
	public void setUser_mobno(long user_mobno) {
		this.user_mobno = user_mobno;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getTrainerpreference() {
		return trainerpreference;
	}
	public void setTrainerpreference(String trainerpreference) {
		this.trainerpreference = trainerpreference;
	}
	public Integer getNoofweeks() {
		return noofweeks;
	}
	public void setNoofweeks(Integer noofweeks) {
		this.noofweeks = noofweeks;
	}
	public Integer getPacakageselected() {
		return pacakageselected;
	}
	public void setPacakageselected(Integer pacakageselected) {
		this.pacakageselected = pacakageselected;
	}
	public boolean isPhysiorequired() {
		return physiorequired;
	}
	public void setPhysiorequired(boolean physiorequired) {
		this.physiorequired = physiorequired;
	}
}

