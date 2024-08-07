
package com.example.Voting_System_Application_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.example.Voting_System_Application_SpringBoot.entity.Voter;

public interface VoterService {

    Voter saveVoter(Voter voter);
    List<Voter> voterlist();
    void deleteById(int id);
    Voter findById1(int id);
    Voter updateVoter(Voter voter, int id);
    Voter findVoterByUsernameAndPassword(String username, String password);
    void updateVoter(Voter voter);
}
