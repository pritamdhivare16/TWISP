package com.dtos;


import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDtos {
	private String party;
	private String candidateImage;	
	private String partySymbol;
	private String occupation;	
	private String education;	
	private Long voteCount;	
    private String fName;
    private String lName;
    private String voterId;
    private String constituency ;
    private String mobile;
    private Date dob;
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
	public Long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
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
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
    
	
}
