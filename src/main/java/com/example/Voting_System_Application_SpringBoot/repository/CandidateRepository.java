
package com.example.Voting_System_Application_SpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;
import com.example.Voting_System_Application_SpringBoot.entity.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
	Optional<Candidate> findByEmail(String email);	
}
