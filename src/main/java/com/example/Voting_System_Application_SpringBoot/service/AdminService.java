
package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;
import com.example.Voting_System_Application_SpringBoot.entity.Election;

public interface AdminService {
	public void saveAdmin(Admin admin);
	
	public List<Admin> adminList();

	public void deleteById(int id);

	//public Admin findAdminByUsernameAndPassword(String username, String password);


}
