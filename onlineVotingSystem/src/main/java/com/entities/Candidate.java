package com.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate extends BaseEntity{
	
	@Column(length=30)
	private String party;
	
	@Lob
	@Column(name="candidateImage")
	private String candidateImage;
	
	@Lob
	@Column(name="partySymbol")
	private String partySymbol;
	
	@Column(length=30)
	private String occupation;
	
	@Column(length=30)
	private String education;
	
	@Column(name="voteCount" ,length=10)
	private Long voteCount;
	
	@ManyToOne
	@JoinColumn(name = "electionDetailsId")
	private ElectionDetails electionDetails;
	
	@OneToOne
	@JoinColumn(name="electionDataId")
	private ElectionData electionData;
	
	@Column(length = 20)
	private String status;

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String party, String candidateImage, String partySymbol, String occupation, String education,
			 ElectionDetails electionDetails, ElectionData electionData, String status) {
		super();
		this.party = party;
		this.candidateImage = candidateImage;
		this.partySymbol = partySymbol;
		this.occupation = occupation;
		this.education = education;
		this.electionDetails = electionDetails;
		this.electionData = electionData;
		this.status = status;
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

	public ElectionDetails getElectionDetails() {
		return electionDetails;
	}

	public void setElectionDetails(ElectionDetails electionDetails) {
		this.electionDetails = electionDetails;
	}

	public ElectionData getElectionData() {
		return electionData;
	}

	public void setElectionData(ElectionData electionData) {
		this.electionData = electionData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
