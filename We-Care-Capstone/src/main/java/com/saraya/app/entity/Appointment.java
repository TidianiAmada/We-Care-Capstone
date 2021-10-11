package com.saraya.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer booking_id;
	private LocalDate appointment_date;
	private String slot;
	
	/**
	 * @return the booking_id
	 */
	public Integer getBooking_id() {
		return booking_id;
	}


	/**
	 * @param booking_id the booking_id to set
	 */
	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}


	/**
	 * @return the appointment_date
	 */
	public LocalDate getAppointment_date() {
		return appointment_date;
	}


	/**
	 * @param appointment_date the appointment_date to set
	 */
	public void setAppointment_date(LocalDate appointment_date) {
		this.appointment_date = appointment_date;
	}


	/**
	 * @return the slot
	 */
	public String getSlot() {
		return slot;
	}


	/**
	 * @param slot the slot to set
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}


	/**
	 * @return the appUser
	 */
	public AppUser getAppUser() {
		return appUser;
	}


	/**
	 * @param appUser the appUser to set
	 */
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	/**
	 * @return the coach
	 */
	public Coach getCoach() {
		return coach;
	}


	/**
	 * @param coach the coach to set
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}


	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private AppUser appUser;
	@OneToMany(fetch = FetchType.LAZY)
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
