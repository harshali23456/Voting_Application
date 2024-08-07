
package com.example.Voting_System_Application_SpringBoot.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Election {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	private LocalDate DOB;
	private String location;
	private String candidate;
	private boolean is_active;
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
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public Election(int id, @NotBlank(message = "Name cannot be empty") String name, LocalDate dOB, String location,
			String candidate, boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.location = location;
		this.candidate = candidate;
		this.is_active = is_active;
	}
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Election [id=" + id + ", name=" + name + ", DOB=" + DOB + ", location=" + location + ", candidate="
				+ candidate + ", is_active=" + is_active + "]";
	}
	
	
}
