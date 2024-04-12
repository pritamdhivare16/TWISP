package com.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Voter;

public interface VoterDao extends JpaRepository<Voter, Long> {

	Voter findByVoterIdAndPassword(String vId, String pass);
    Voter findByVoterId(String voterId);
}
