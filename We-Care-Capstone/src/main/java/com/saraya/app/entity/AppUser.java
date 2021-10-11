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
public class AppUser {
	@Id
	@Column
	private String user_id;
	
	private String name;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date date_of_birth;
	
	private String email;
	
	private Integer pinCode;
	
	private String city;
	
	private String state;
	
	private String country;

	public AppUser(String name, String password, Gender gender, Date date_of_birth, String email, Integer pinCode,
			String city, String state, String country) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	

}
