
package com.example.Voting_System_Application_SpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name Cannot be Empty")
	@Size(min = 2, max = 12, message = "Name should have 2 to 12 characters")
	@Pattern(regexp = "[a-zA-Z]+$",message = "only character allowed")
	private String name;
	private String logo;
	private String ward;
	private String city;
	private String email;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int id,
			@NotBlank(message = "Name Cannot be Empty") @Size(min = 4, max = 8, message = "Name should have 4 to 8 characters") @Pattern(regexp = "[a-zA-Z]+$", message = "only character allowed") String name,
			String logo, String ward, String city, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.ward = ward;
		this.city = city;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", logo=" + logo + ", ward=" + ward + ", city=" + city
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
}
