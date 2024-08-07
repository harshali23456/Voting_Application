
package com.example.Voting_System_Application_SpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Optional<Admin> findByUsername(String username);
}
