
package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;
import com.example.Voting_System_Application_SpringBoot.entity.Election;

public interface ElectionService {
	public void saveElection(Election election);

	public List<Election> Electionlist();
	public void deleteById(int id);
}
