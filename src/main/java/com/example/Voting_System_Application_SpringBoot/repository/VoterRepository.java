
package com.example.Voting_System_Application_SpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Voting_System_Application_SpringBoot.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {
    Optional<Voter> findByUsername(String username);

    Voter findByUsernameAndPassword(String username, String password);
}
