
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

import com.example.Voting_System_Application_SpringBoot.entity.Candidate;
import com.example.Voting_System_Application_SpringBoot.repository.CandidateRepository;
import com.example.Voting_System_Application_SpringBoot.service.CandidateService;

@Controller
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepo;

    @Autowired
    CandidateService candidateService;

    @GetMapping("/saveCandidate")
    public String saveCandidate(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidateregister";
    }

    @PostMapping("/gocandidateregister")
    public String registerCandidate(@ModelAttribute Candidate candidate, Model model) {
        candidateService.saveCandidate(candidate);
        return "dashboard";
    }

    @GetMapping("/candidatelogin")
    public String showCandidateLogin(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidatelogin";
    }

    @PostMapping("/gocandidatelogin")
    public String handleCandidateLogin(@ModelAttribute Candidate candidate, Model model) {
        Optional<Candidate> existingCandidateOpt = candidateRepo.findByEmail(candidate.getEmail());

        if (existingCandidateOpt.isPresent()) {
            Candidate existingCandidate = existingCandidateOpt.get();
            if (existingCandidate.getPassword().equals(candidate.getPassword())) {
                return "dashboard";
            }
        }
        model.addAttribute("error", true);
        return "candidatelogin";
    }

    @GetMapping("/candidatelist")
    public String viewAllCandidates(Model model) {
        List<Candidate> candidateList = candidateService.candidateList();
        model.addAttribute("candidatelist", candidateList);
        return "candidatelist";
    }

    @GetMapping("/deletecandidate/{id}")
    public String deleteCandidate(@PathVariable("id") int id) {
        candidateService.deleteById(id);
        return "redirect:/candidatelist";
    }
}
