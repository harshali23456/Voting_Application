
package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;
import com.example.Voting_System_Application_SpringBoot.entity.Election;
import com.example.Voting_System_Application_SpringBoot.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminRepo.save(admin);
		
	}
	
	@Override
	public List<Admin> adminList(){
		List<Admin>find=adminRepo.findAll();		
		return find;
	}

	@Override
	public void deleteById(int id) {
		adminRepo.deleteById(id);
		
	}

	

}
