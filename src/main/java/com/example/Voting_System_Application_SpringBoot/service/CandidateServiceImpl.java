package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Voting_System_Application_SpringBoot.entity.Candidate;
import com.example.Voting_System_Application_SpringBoot.repository.CandidateRepository;
@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	CandidateRepository candidateRepo;
	
	@Override
	public void saveCandidate(Candidate candidate) {
		candidateRepo.save(candidate);
		
	}

	@Override
	public List<Candidate> candidateList() {
		List<Candidate> find=candidateRepo.findAll();
		return find;
	}
	@Override
	public void deleteById(int id) {
		candidateRepo.deleteById(id);
		
	}
}