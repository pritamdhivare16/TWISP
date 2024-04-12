package com.dtos;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ElectionCandidateDto {
	long id;
	private String fName;
	private String lName;
	private String party;
	private String candidateImage;	
	private String partySymbol;
	private String gender;
	private Long voteCount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}
	public ElectionCandidateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElectionCandidateDto(long id, String fName, String lName, String party, String candidateImage,
			String partySymbol, String gender, Long voteCount) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.party = party;
		this.candidateImage = candidateImage;
		this.partySymbol = partySymbol;
		this.gender = gender;
		this.voteCount = voteCount;
	}	
	
	
}