package com.saraya.app.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Coach;
import com.saraya.app.service.AppointmentService;

@RestController @RequestMapping("/api/coach")
public class CoachController {

	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/save")
	public ResponseEntity<Coach> saveCoach(Coach coach) {
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save").toUriString());
		return ResponseEntity.created(uri).body(appointmentService.coachSubscribe(coach));
	}
	@GetMapping("retrieveUser")
	public AppUser showProfileUser(String user_id) {
		return appointmentService.viewProfileOfAppUser(user_id);
	}
	
}
