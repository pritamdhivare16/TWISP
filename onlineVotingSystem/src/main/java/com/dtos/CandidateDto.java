package com.dtos;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class CandidateDto {
	
	private String party;
	private MultipartFile candidateImage;	
	private MultipartFile partySymbol;
	private String occupation;	
	private String education;	
//	private Long voteCount;	
	private Long electionDetailsID;	
	private Long electionDataID;	
//	private String status;
	public CandidateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
public CandidateDto(String party, MultipartFile candidateImage, MultipartFile partySymbol, String occupation,
		String education, Long electionDetailsID, Long electionDataID) {
	super();
	this.party = party;
	this.candidateImage = candidateImage;
	this.partySymbol = partySymbol;
	this.occupation = occupation;
	this.education = education;
	this.electionDetailsID = electionDetailsID;
	this.electionDataID = electionDataID;
}
public String getParty() {
	return party;
}
public void setParty(String party) {
	this.party = party;
}
public MultipartFile getCandidateImage() {
	return candidateImage;
}
public void setCandidateImage(MultipartFile candidateImage) {
	this.candidateImage = candidateImage;
}
public MultipartFile getPartySymbol() {
	return partySymbol;
}
public void setPartySymbol(MultipartFile partySymbol) {
	this.partySymbol = partySymbol;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public Long getElectionDetailsID() {
	return electionDetailsID;
}
public void setElectionDetailsID(Long electionDetailsID) {
	this.electionDetailsID = electionDetailsID;
}
public Long getElectionDataID() {
	return electionDataID;
}
public void setElectionDataID(Long electionDataID) {
	this.electionDataID = electionDataID;
}
	
	
}
