package com.saraya.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;
import com.saraya.app.repository.AppointmentRepo;
import com.saraya.app.repository.CoachRepo;
import com.saraya.app.repository.UserRepo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class AppointmentServiceImpl implements AppointmentService{

	private UserRepo userRepo;
	private CoachRepo coachRepo;
	private AppointmentRepo appointmentRepo;
	
	// Contructor injection
	
	@Autowired
	public AppointmentServiceImpl(UserRepo userRepository) {
		this.userRepo=userRepository;
	}
	
	@Autowired
	public AppointmentServiceImpl(CoachRepo coachRepository) {
		this.coachRepo=coachRepository;
	}
	
	@Autowired
	public AppointmentServiceImpl(AppointmentRepo appointmentRepository) {
		this.appointmentRepo=appointmentRepository;
	}
	
	
	
	@Override
	public Coach viewProfileOfCoach(String coach_id) {
		return coachRepo.findByCoach_Id(coach_id);
	}

	@Override
	public AppUser viewProfileOfAppUser(String user_id) {
		return userRepo.findByUser_Id(user_id);
	}

	@Override
	public List<Coach> viewAllLifeCoachs() {
		return coachRepo.findAll();
	}

	@Override
	public Appointment bookAppointment(Appointment appointment) {
		// TODO is it better to pass an appointment as argument?? or Its parameters?
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<Appointment> viewUpcomingAppointmentsForUser(String user_id) {
		return appointmentRepo.findAllByUser_Id(user_id);
	}

	@Override
	public List<Appointment> viewUpcomingAppointmentsForCoach(String coach_id) {
		return appointmentRepo.findAllByCoach_Id(coach_id);
	}

	@Override
	public Appointment rescheduleAppointment(Integer booking_id, LocalDate appointment_date) {
		Appointment rdv=appointmentRepo.findByBooking_Id(booking_id);
		// how to update
		rdv.setAppointment_date(appointment_date);
		appointmentRepo.save(rdv);
		return rdv;
	}

	@Override
	public void cancelAppointment(Integer booking_id) {
		Appointment rdv=appointmentRepo.findByBooking_Id(booking_id);
		appointmentRepo.delete(rdv);
		
	}

}
