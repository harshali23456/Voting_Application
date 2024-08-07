package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;

import com.example.Voting_System_Application_SpringBoot.entity.Candidate;

public interface CandidateService {
	public void saveCandidate(Candidate candidate);
	public List<Candidate> candidateList();
	public void deleteById(int id);
}