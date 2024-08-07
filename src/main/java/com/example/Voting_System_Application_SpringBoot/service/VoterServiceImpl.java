package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Voting_System_Application_SpringBoot.entity.Voter;
import com.example.Voting_System_Application_SpringBoot.repository.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    VoterRepository voterrepo;

    @Override
    public Voter saveVoter(Voter voter) {
        return voterrepo.save(voter);
    }

    @Override
    public List<Voter> voterlist() {
        return voterrepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        voterrepo.deleteById(id);
    }

    @Override
    public Voter findById1(int id) {
        Optional<Voter> findById = voterrepo.findById(id);
        return findById.orElse(null);
    }

    @Override
    public Voter updateVoter(Voter voter, int id) {
        Optional<Voter> voterdatab = voterrepo.findById(id);
        if (voterdatab.isPresent()) {
            Voter newVoter = voterdatab.get();
            newVoter.setUsername(voter.getUsername());
            newVoter.setDOB(voter.getDOB());
            newVoter.setGender(voter.getGender());
            newVoter.setPassword(voter.getPassword());
            voterrepo.save(newVoter);
            return newVoter;
        }
        return null;
    }
    public Voter findVoterByUsernameAndPassword(String username, String password) {
        return voterrepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public void updateVoter(Voter voter) {
        voterrepo.save(voter);
    }
}