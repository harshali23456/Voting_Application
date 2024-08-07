
package com.example.Voting_System_Application_SpringBoot.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Voting_System_Application_SpringBoot.entity.Voter;
import com.example.Voting_System_Application_SpringBoot.repository.VoterRepository;
import com.example.Voting_System_Application_SpringBoot.service.VoterService;

import jakarta.validation.Valid;

@Controller
public class VoterController {

    @Autowired
    VoterRepository voterrepo;
    
    @Autowired
    VoterService voterService;

    @GetMapping("/saveVoter")
    public String saveVoter(Model model) {
        model.addAttribute("voter", new Voter());
        return "VoterRegister";
    }

    @PostMapping("/govoterregister")
    public String getVoterStatus(@Valid @ModelAttribute Voter voter, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "VoterRegister";
        }
        LocalDate today = LocalDate.now();
        Period age = Period.between(voter.getDOB(), today);
        if (age.getYears() < 18) {
            model.addAttribute("ageError", "You must be at least 18 years old to register.");
            return "VoterRegister";
        }
        voterService.saveVoter(voter);
        return "VoterLogin";
    }

    @GetMapping("/voterlogin")
    public String showVoterLogin(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterlogin";
    }

    @PostMapping("/govoterlogin")
    public String handleVoterLogin(@ModelAttribute Voter voter, Model model) {
        Optional<Voter> existingVoterOpt = voterrepo.findByUsername(voter.getUsername());
        if (existingVoterOpt.isPresent()) {
            Voter existingVoter = existingVoterOpt.get();
            if (existingVoter.getPassword().equals(voter.getPassword())) {
                return "VoterDashboard";
            }
        }
        model.addAttribute("error", true);
        return "voterlogin";
    }

    @GetMapping("/VoterDashboard")
    public String VoterDashboard() {
        return "VoterDashboard";
    }

    @GetMapping("/voterlist")
    public String viewAllVoters(Model model) {
        List<Voter> voterList = voterService.voterlist();
        model.addAttribute("voterList", voterList);
        return "voterlist";
    }

    @GetMapping("/deleteVoter/{id}")
    public String deleteVoter(@PathVariable("id") int id) {
        voterService.deleteById(id);
        return "redirect:/voterlist";
    }

    @GetMapping("/editVoter/{id}")
    public String editVoterForm(@PathVariable("id") Integer id, Model model) {
        Voter voter = voterrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid voter Id:" + id));
        model.addAttribute("voter", voter);
        return "VoterEdit";
    }

    @PostMapping("/updateVoter/{id}")
    public String updateVoter(@PathVariable("id") Integer id, @ModelAttribute("voter") Voter updatedVoter) {
        Voter existingVoter = voterrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid voter Id:" + id));

        existingVoter.setVoterName(updatedVoter.getVoterName());
        existingVoter.setDOB(updatedVoter.getDOB());
        existingVoter.setGender(updatedVoter.getGender());
        existingVoter.setUsername(updatedVoter.getUsername());
        existingVoter.setPassword(updatedVoter.getPassword());

        voterrepo.save(existingVoter);

        return "redirect:/voterlist";
    }

    @GetMapping("/updateVoter")
    public String showUpdateForm() {
        return "UpdateVoterRequest";
    }
   
    @PostMapping("/findVoterForUpdate")
    public String findVoterForUpdat(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Voter voter = voterrepo.findByUsernameAndPassword(username, password);
        if (voter != null) {
            model.addAttribute("voter", voter);
            return "UpdateVoterForm"; // Redirect to the update form
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "UpdateVoterRequest"; // Stay on the same page and show an error
        }
    }
//    @GetMapping("/updateVoterForm")
//    public String showUpdate() {
//        return "UpdateVoterForm";
//    }

    @PostMapping("/updateVoterDetails")
    public String updateVoterDetails(@ModelAttribute Voter voter) {
        voterrepo.save(voter);
        return "redirect:/voterlist"; // Redirect back to the voter list page after update
    }
}
