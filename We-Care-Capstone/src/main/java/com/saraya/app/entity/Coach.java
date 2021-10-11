package com.saraya.app.entity;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	private String coach_id;
	
	@NotBlank(message = "{user.name.must}")
	private String name;
	
	@NotEmpty(message = "{user.password.must}")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$", message = "{user.password.invalid}")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date date_of_birth;
	
	private Long mobile_number;
	
	private String speciality;

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

	@Override
	public String toString() {
		return "Coach [coach_id=" + coach_id + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", mobile_number=" + mobile_number + ", speciality=" + speciality
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coach_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coach other = (Coach) obj;
		return Objects.equals(coach_id, other.coach_id);
	}
	

}
