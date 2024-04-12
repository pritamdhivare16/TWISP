package com.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voter")
public class Voter extends BaseEntity{
     
     @Column(length = 20 )
	 private String voterId;
     
     @Column(length = 15 )
	 private String mobile;
     
     @Column(length = 20 )
	 private String password;
     
     @Column(length = 15 )
	 private String status;

	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voter(String voterId, String mobile, String password, String status) {
		super();
		this.voterId = voterId;
		this.mobile = mobile;
		this.password = password;
		this.status = status;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
     
     

     
     
}
