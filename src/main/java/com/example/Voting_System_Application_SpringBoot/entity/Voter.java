
package com.example.Voting_System_Application_SpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
@Entity
public class Voter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name cannot be empty")
    private String voterName;

    @Past(message = "Date of Birth must be in the past")
    private LocalDate DOB;

    private String gender;

    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Voter(int id, @NotBlank(message = "Name cannot be empty") String voterName,
			@Past(message = "Date of Birth must be in the past") LocalDate dOB, String gender,
			@NotBlank(message = "Username cannot be empty") String username,
			@NotBlank(message = "Password cannot be empty") String password) {
		super();
		this.id = id;
		this.voterName = voterName;
		DOB = dOB;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}

	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", voterName=" + voterName + ", DOB=" + DOB + ", gender=" + gender + ", username="
				+ username + ", password=" + password + "]";
	}

    
}
