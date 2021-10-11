package com.saraya.app.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String booking_id;
	private LocalDate appointment_date;
	private String slot;
	
	@OneToMany
	private AppUser appUser;
	@OneToMany
	private Coach coach;
	
	
	public Appointment(LocalDate appointment_date, String slot, AppUser appUser, Coach coach) {
		super();
		this.appointment_date = appointment_date;
		this.slot = slot;
		this.appUser = appUser;
		this.coach = coach;
	}
	
	

}
