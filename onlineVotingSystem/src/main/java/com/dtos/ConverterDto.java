package com.dtos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.ElectionDataDao;
import com.dao.ElectionDetailsDao;
import com.entities.Candidate;
import com.entities.ElectionData;
import com.entities.ElectionDetails;

@Component
public class ConverterDto {
	
	
	public Candidate candDtotoEntity(CandidateDto candidateDto)
	{
		Candidate candidate = new Candidate();
		
		BeanUtils.copyProperties(candidateDto, candidate, "thumbnail");
		
		if(candidateDto.getCandidateImage() != null && candidateDto.getPartySymbol()!= null)
		{
			candidate.setCandidateImage(candidateDto.getCandidateImage().getOriginalFilename());
			candidate.setPartySymbol(candidateDto.getPartySymbol().getOriginalFilename());
		
		}
		
		return candidate;
	}
	
	public CandidateDtos toCandidateDtos(Candidate c , ElectionData electionData) {
		CandidateDtos candidate = new CandidateDtos();
		candidate.setfName(electionData.getfName());
		candidate.setlName(electionData.getlName());
		candidate.setMobile(electionData.getMobile());
		candidate.setDob(electionData.getDob());
		candidate.setEducation(c.getEducation());
		candidate.setOccupation(c.getOccupation());
		candidate.setParty(c.getParty());
		candidate.setVoteCount(c.getVoteCount());
		candidate.setVoterId(electionData.getVoterId());
		candidate.setConstituency(electionData.getConstituency());
		// Image load from front end by using candidateImage name
		candidate.setCandidateImage(c.getCandidateImage());
		// Image load from front end by using partySymbole name
		candidate.setPartySymbol(c.getPartySymbol());
		
		return candidate;
	}
	
}