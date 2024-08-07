
package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;
import com.example.Voting_System_Application_SpringBoot.entity.Election;
import com.example.Voting_System_Application_SpringBoot.repository.AdminRepository;
import com.example.Voting_System_Application_SpringBoot.repository.ElectionRepository;

@Service
public class ElectionServiceImpl implements ElectionService{
	@Autowired
	ElectionRepository electionrepo;
	@Override
	public void saveElection(Election election) {
		electionrepo.save(election);
	}
	@Override
	public List<Election> Electionlist() {
		 return electionrepo.findAll();
	}
	@Override
	public void deleteById(int id) {
		electionrepo.deleteById(id);
		
	}
}
