package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dtos.VotingforCandidateDto;
import com.entities.Candidate;

@Service
public interface CandidateService {
	

	public String registerCandidate(Candidate candidate);


	public List<VotingforCandidateDto> getCandidateDetails(VotingforCandidateDto electionVoterId);
	public String verifyCandidateByAdmin(long candidateId);

	public String rejectCandidateByAdmin(long candidateId);


}