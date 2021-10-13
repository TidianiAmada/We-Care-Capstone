package com.saraya.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity @Data
public class Coach {
	
	@Id
	@Column
	private String coachId;
	
	private String name;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date date_of_birth;
	
	private Long mobile_number;
	
	private String speciality;

	public Coach() {
		super();
	}

	public Coach(String name, String password, Gender gender, Date date_of_birth, Long mobile_number,
			String speciality) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}

	public Coach(String coach_id, String name, String password, Gender gender, Date date_of_birth, Long mobile_number,
			String speciality) {
		super();
		this.coachId = coach_id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}
	
	
	

}
