package com.saraya.app;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;
import com.saraya.app.entity.Gender;
import com.saraya.app.service.AppointmentService;

@SpringBootApplication
public class WeCareCapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeCareCapstoneApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(AppointmentService appointmentService){
		return args -> {
			appointmentService.userSubscribe(new AppUser("U001","Lam", "password", Gender.M, new Date(5,2,1997), "lam@saraya.com", 1234, "Dakar", "Senegal", "CEDEAO"));
			appointmentService.userSubscribe(new AppUser("U002","Kande", "password", Gender.M, new Date(8,8,1999), "kande@saraya.com", 1234, "Ndar", "Senegal", "CEDEAO"));
			appointmentService.userSubscribe(new AppUser("U003","konate", "password", Gender.M, new Date(5,12,1997), "konate@saraya.com", 1234, "Touba", "Senegal", "CEDEAO"));
			
			appointmentService.coachSubscribe(new Coach("C001","Kane", "password", Gender.M, new Date(5,4,2000), 772532609L, "Psychologue"));
			appointmentService.coachSubscribe(new Coach("C002","Sow", "password", Gender.F, new Date(5,4,2002), 772556609L, "Psychanalyste"));

			AppUser us1 =appointmentService.viewProfileOfAppUser("U001");
			AppUser us2 =appointmentService.viewProfileOfAppUser("U002");
			AppUser us3 =appointmentService.viewProfileOfAppUser("U003");
			Coach ch1 =appointmentService.viewProfileOfCoach("C001");
			Coach ch2 =appointmentService.viewProfileOfCoach("C002");
			// new LocalDate(2022,12, 12)
			
			Appointment book=new Appointment(null, "3H",us1 ,ch1 );
			appointmentService.bookAppointment(book);
			Appointment book2=new Appointment(null, "3H",us2 ,ch1 );
			appointmentService.bookAppointment(book2);
			Appointment book3=new Appointment(null, "3H",us3 ,ch2 );
			appointmentService.bookAppointment(book3);
			Appointment book4=new Appointment(null, "3H",us2 ,ch2 );
			appointmentService.bookAppointment(book4);
			
		};
	}

}
