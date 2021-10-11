package com.saraya.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer booking_id;

	//@Temporal(TemporalType.DATE)
	private LocalDate appointment_date;

	private String slot;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private AppUser appUser;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "coach_id")
	private Coach coach;
	
	
	public Appointment(LocalDate appointment_date, String slot, AppUser appUser, Coach coach) {
		super();
		this.appointment_date = appointment_date;
		this.slot = slot;
		this.appUser = appUser;
		this.coach = coach;
	}
	
	

}
