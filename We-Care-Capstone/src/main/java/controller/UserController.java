package controller;

import java.net.URI;
import java.util.List;

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

// TODO mapping
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	AppointmentService appointmentService;
	
	//TODO create user and coach
	
	
	@PostMapping("/save")
	public ResponseEntity<AppUser> saveUser(AppUser user) {
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/save").toUriString());
		return ResponseEntity.created(uri).body(appointmentService.userSubscribe(user));
	}
	
	@GetMapping("retrieveCoach")
	public Coach showProfileCoach(String coach_id) {
		return appointmentService.viewProfileOfCoach(coach_id); 
	}
	
	@GetMapping("retrieveCoachs")
	public List<Coach> showAlllifecoach(){
		return appointmentService.viewAllLifeCoachs();
	}
	
}
