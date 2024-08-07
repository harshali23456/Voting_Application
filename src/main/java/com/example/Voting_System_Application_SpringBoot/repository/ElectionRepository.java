
package com.example.Voting_System_Application_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Voting_System_Application_SpringBoot.entity.Election;

public interface ElectionRepository extends JpaRepository<Election, Integer>{

}
