package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ElectionDataDao;
import com.dao.ElectionDetailsDao;
import com.dtos.CandidateDto;
import com.dtos.CandidateDtos;
import com.dtos.ConverterDto;
import com.dtos.VotingforCandidateDto;
import com.entities.Candidate;
import com.entities.ElectionData;
import com.entities.ElectionDetails;
import com.service.CandidateService;
import com.service.ElectionDetailsService;
import com.service.StorageService;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = {"*"})
public class CandidateController {

	
	@Autowired
	public CandidateService candidateServ;
	
	@Autowired
	public ConverterDto converter;
	
	@Autowired 
	public StorageService storageService;

	@Autowired
	public ElectionDetailsDao edtailsDao;
	
	@Autowired
	public ElectionDataDao edataDao;	
	
	@Autowired
	public ElectionDetailsService electionDetailsService;
	
	@PostMapping("/register")
	public String registerCandidate(CandidateDto candidateDto) {
		
		Candidate cand = converter.candDtotoEntity(candidateDto);
		
		ElectionDetails ed = edtailsDao.findById(candidateDto.getElectionDetailsID()).orElseThrow();
		ElectionData edta = edataDao.findById(candidateDto.getElectionDataID()).orElseThrow();

		Candidate cand1 = new Candidate(candidateDto.getParty(),cand.getCandidateImage(),cand.getPartySymbol(),candidateDto.getOccupation(),candidateDto.getEducation(),ed,edta,"pending");
		
		String thumbnailCand = storageService.store(candidateDto.getCandidateImage());
		String thumbnailParty = storageService.store(candidateDto.getPartySymbol());
		
		return candidateServ.registerCandidate(cand1);  

	}
	
	 @GetMapping("/verifyCandidate/{candidateId}")
	    public ResponseEntity<String> verifyCandidate(@PathVariable long candidateId){
	    	String verify =  candidateServ.verifyCandidateByAdmin(candidateId);
	             return	ResponseEntity.ok(verify);
	    	   
	     }
	
	 @GetMapping("/rejectCandidate/{candidateId}")
	    public ResponseEntity<String> rejectCandidate(@PathVariable long candidateId){
	    	String reject =  candidateServ.rejectCandidateByAdmin(candidateId);
	             return	ResponseEntity.ok(reject);
	    	   
	     }
	 @GetMapping("/allCandidate/{electionId}")
	   public ResponseEntity<?> getAllCandidateByElectionId(@PathVariable long electionId){
		 List<CandidateDtos> candidates = electionDetailsService.getAllCandidates(electionId);
		   return ResponseEntity.ok(candidates);
	   }
	
	@GetMapping("/verified")
	public List<VotingforCandidateDto> getCandidateDetails(VotingforCandidateDto electionVoterId) {
		
		List<VotingforCandidateDto> cd = candidateServ.getCandidateDetails(electionVoterId);
		
		return cd;
	}
	
	
}