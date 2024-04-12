package com.dtos;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class VotingforCandidateDto {

	private String voterId;
	private Long electionDataId;
	
	 private String fName;
	 private String lName;
	 private String party;
	 private String candidateImage;
	 private String partySymbol;
	 
	public VotingforCandidateDto(String fName, String lName, String party, String candidateImage, String partySymbol) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.party = party;
		this.candidateImage = candidateImage;
		this.partySymbol = partySymbol;
	}
	

	public VotingforCandidateDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public Long getElectionDataId() {
		return electionDataId;
	}

	public void setElectionDataId(Long electionDataId) {
		this.electionDataId = electionDataId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getCandidateImage() {
		return candidateImage;
	}

	public void setCandidateImage(String candidateImage) {
		this.candidateImage = candidateImage;
	}

	public String getPartySymbol() {
		return partySymbol;
	}

	public void setPartySymbol(String partySymbol) {
		this.partySymbol = partySymbol;
	}
	 
	
	 

}