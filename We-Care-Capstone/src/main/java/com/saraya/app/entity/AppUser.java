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
import javax.persistence.Id;

import lombok.Data;


@Entity @Data
public class AppUser {

	@Id
	@Column
	private String user_id;
	
	@NotBlank(message="{user.name.must}")
	private String name;
	
	@NotEmpty(message="{user.password.must}")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$",message= "{user.password.invalid}")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date date_of_birth;
	
	@NotNull(message="{user.email.must}")
	@Email(message= "{user.email.invalid}")
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

	@Override
	public int hashCode() {
		return Objects.hash(user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		return Objects.equals(user_id, other.user_id);
	}

	@Override
	public String toString() {
		return "AppUser [user_id=" + user_id + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", email=" + email + ", pinCode=" + pinCode + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]";
	}
	

}
