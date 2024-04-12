package com.dtos;


import java.util.Date;
import java.util.List;

import com.entities.ElectionData;
import com.entities.ElectionDetails;

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
public class ElectionDetailsDto {
        

		 long id;
		 private String nameOfElection;
		 
		 private String constituency ;
		 
		 private Date startDate;
		 
		 private Date endDate;
		 
		  private String state;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

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

		public ElectionDetailsDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ElectionDetailsDto(long id, String nameOfElection, String constituency, Date startDate, Date endDate,
				String state) {
			super();
			this.id = id;
			this.nameOfElection = nameOfElection;
			this.constituency = constituency;
			this.startDate = startDate;
			this.endDate = endDate;
			this.state = state;
		}

		  
		
}
