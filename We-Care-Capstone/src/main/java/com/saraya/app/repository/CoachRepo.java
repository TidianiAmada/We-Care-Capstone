package com.saraya.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.saraya.app.entity.Coach;

public interface CoachRepo extends JpaRepository<Coach, String> {
	
	// 3 - all life coach
	List<Coach> findAll();
	
	// to view coach profile by user
	Coach findByCoach_Id(String coach_id);

}
