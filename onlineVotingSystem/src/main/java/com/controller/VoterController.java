package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtos.VoterDto;
import com.dtos.VoterIdCandidateId;
import com.entities.Voter;
import com.service.VoterService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/voter")
public class VoterController {
	
	@Autowired
	private VoterService voterService;
	
	
	
	@PostMapping("/register")
	public String registerVoter(@RequestBody Voter voter) {
		 String msg = voterService.registerVoterService(voter);
		 if(msg!=null) {
			 return "Voter Registered Succesfully";
		 }else {
			 return "Can't Register,Voter Not Present in Election Commission Data";
		 }
		
		
	}
	
	@GetMapping("/login")
	public Voter signIn(@RequestBody Voter voter) {
		
		String vId = voter.getVoterId();
		String pass = voter.getPassword();
		
		if(vId !=null && pass!=null) {
			return voterService.login(vId,pass);
		}else {
			return null;
		}
		
	}
	
	@PostMapping("/vote")
	public String voteForCandidate(@RequestBody VoterIdCandidateId vIdcId ){
		  return   voterService.votForCandidates(vIdcId);
		     
	}
	
	@GetMapping("/voterDetails/{voterId}")
	public VoterDto findVoterDetails(@PathVariable String voterId) {
		 return   voterService.getVoterDetails(voterId); 
	
	}
	
	

}
