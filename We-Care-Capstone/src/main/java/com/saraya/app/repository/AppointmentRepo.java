package com.saraya.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
	
//	List<Appointment> findAllByAppointmentDate(LocalDate appointment_date);
	
	// List<Appointment> findAllByUserId(String user_id);
	
	
	// 1-a Profile of User, need by coach
	AppUser findByAppUserId(String user_id);
	
	// 1-b Profile of Coach, need by user
	Coach findByCoachId(String coach_id);
	
	// 2 Booking an appointment, use save built in method
	
// 3 is given by CoachRepo
	// 4- To keep it simple we'll retrieve all appointments
	List<Appointment> findAllBy(String user_id); 
	
	// TODO: 3+ retrieve a Sorted and Sized Pageable of upcomming appointments
	
	// 5- reschedule an appointment, use findBydate then set and save
	
	// 6- cancel an appointment, use findById then delete
	
	

}
