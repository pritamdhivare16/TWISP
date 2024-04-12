package com.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.dtos.CandidateDtos;
import com.dtos.ElectionCandidateDto;
import com.dtos.ElectionDetailsDto;
import com.dtos.PrevElectionDetailsDto;
import com.entities.ElectionDetails;

public interface ElectionDetailsService {
	public List<ElectionDetailsDto> getAllElectionDetails();
	public List<PrevElectionDetailsDto> getPreviousElectionDetails();
	public ElectionDetailsDto addElectionDetails(ElectionDetailsDto electionDetailsDto);
	public Set<String> getElectionNamesList() ;
	public ElectionDetailsDto getTodayElectionDetails(String constituency);
	public List<ElectionCandidateDto> getElectionCandidateList(long id);
	public List<CandidateDtos> getAllCandidates(long electionId);
	Optional<ElectionDetails> findElectionDetails(long id);



}