package com.saraya.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.app.entity.AppUser;


public interface UserRepo extends JpaRepository<AppUser, String> {
	
	// to view user profile by coach
	AppUser findByUser_Id(String user_id);

}
