package com.service;

import org.springframework.http.ResponseEntity;

import com.dtos.VoterDto;
import com.dtos.VoterIdCandidateId;
import com.entities.Voter;

public interface VoterService {

	String registerVoterService(Voter voter);

	Voter login(String vId, String pass);

	public String votForCandidates(VoterIdCandidateId vIdcId);

    VoterDto getVoterDetails(String voterId);

}