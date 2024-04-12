package com.dtos;


import java.util.Date;

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
public class PrevElectionDetailsDto {
	 private String nameOfElection;
	 
	 private String constituency ;
	 
	 private Date startDate;
	 
	 private Date endDate;
	 
	  private String state;
	   private String fName;
	   private String lName;
	   private long voteCount;
	   private String party;
	public String getNameOfElection() {
		return nameOfElection;
	}
	public void setNameOfElection(String nameOfElection) {
		this.nameOfElection = nameOfElection;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public long getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(long voteCount) {
		this.voteCount = voteCount;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}

	   
}
