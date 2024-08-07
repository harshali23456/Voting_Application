
package com.example.Voting_System_Application_SpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Voting_System_Application_SpringBoot.entity.Admin;
import com.example.Voting_System_Application_SpringBoot.entity.Election;
import com.example.Voting_System_Application_SpringBoot.repository.AdminRepository;
import com.example.Voting_System_Application_SpringBoot.repository.ElectionRepository;
import com.example.Voting_System_Application_SpringBoot.service.AdminService;
import com.example.Voting_System_Application_SpringBoot.service.ElectionService;

@Controller
public class AdminController {

    @Autowired
    AdminRepository adminRepo;

    @Autowired
    AdminService adminservice;
    @Autowired
	ElectionRepository electionrepo;
    @Autowired
    ElectionService electionService;

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("admin", new Admin());
        return "welcome";
    }
    
    @GetMapping("/saveAdmin")
    public String saveAdmin(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminregister";
    }

    @PostMapping("/goadminregister")
    public String getAdminStatus(@ModelAttribute Admin admin, Model model) {
        adminservice.saveAdmin(admin);
        return "redirect:/adminlogin";
    }
    
    @GetMapping("/adminlogin")
    public String showAdminLogin(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminlogin";
    }

    @PostMapping("/goadminlogin")
    public String handleAdminLogin1(@ModelAttribute Admin admin, Model model) {
        Optional<Admin> existingAdminOpt = adminRepo.findByUsername(admin.getUsername());

        if (existingAdminOpt.isPresent()) {
            Admin existingAdmin = existingAdminOpt.get();
            if (existingAdmin.getPassword().equals(admin.getPassword())) {
                return "dashboard";
            }
        }

        model.addAttribute("error", true);
        return "adminlogin";
    }
    
    @GetMapping("/adminlist")
    public String viewAllAdmin(Model model) {
        List<Admin> adminlist = adminservice.adminList();
        model.addAttribute("adminlist", adminlist);
        return "adminlist";
    }

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable("id") int id) {
        adminservice.deleteById(id);
        return "redirect:/adminlist";
    }
    
    @GetMapping("/backtodashboard")
    public String backToDashboard(Model model) {
        model.addAttribute("admin", new Admin());
        return "dashboard";
    }
    
    
    
    @GetMapping("/saveElection")
    public String saveElection(Model model) {
        return "addElection";
    }

    @PostMapping("/goaddElection")
    public String getElectionStatus(@ModelAttribute Election election, Model model) {
    	electionService.saveElection(election);
        return "dashboard";
    }
    
    @GetMapping("/Electionlist")
    public String viewAllElection(Model model) {
        List<Election> Electionlist = electionService.Electionlist();
        model.addAttribute("Electionlist", Electionlist);
        return "viewElection";
    }

    @GetMapping("/deleteElection/{id}")
    public String deleteElection(@PathVariable("id") int id) {
    	electionService.deleteById(id);
        return "redirect:/viewElection";
    }
}
