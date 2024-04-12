package com.entities;




import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Entity
@Table(name = "electionData")
public class ElectionData extends BaseEntity{
	
	 @Column(length = 30 , name="fname")
	 private String fName;
     
     @Column(length = 30 , name="lname")
	 private String lName;
     
     @Column(length = 20 ,name="voterId")
	 private String voterId;
     
     @Column(length = 20 ,name="aadharNo")
	 private String aadharNo;
     
     @Column(length = 50 )
	 private String constituency ;
     
     @Column(length = 10 )
	 private String gender;
     
     @Column(length = 10  )
	 private String mobile;
     
     @Temporal(TemporalType.DATE)
	 private Date dob;
     
     @Column(length = 15)
     private String state;
     
     @OneToOne(mappedBy = "electionData", cascade = CascadeType.ALL)
     private Candidate candidate;

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

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

     

}
