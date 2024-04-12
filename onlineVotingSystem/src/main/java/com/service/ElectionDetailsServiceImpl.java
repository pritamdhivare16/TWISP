package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.customException.ResourceNotFoundException;
import com.dao.CandidateDao;
import com.dao.ElectionDataDao;
import com.dao.ElectionDetailsDao;
import com.dao.VoterDao;
import com.dtos.CandidateDtos;
import com.dtos.ConverterDto;
import com.dtos.ElectionCandidateDto;
import com.dtos.ElectionDetailsDto;
import com.dtos.PrevElectionDetailsDto;
import com.entities.Candidate;
import com.entities.ElectionData;
import com.entities.ElectionDetails;

@Service
@Transactional
public class ElectionDetailsServiceImpl implements ElectionDetailsService {
@Autowired
ElectionDetailsDao electionDetailsDao;
@Autowired
CandidateDao candidateDao;
@Autowired
ElectionDataDao electionDataDao;
@Autowired
VoterDao voterDao ;
@Autowired
ConverterDto converterDto;

public List<ElectionDetailsDto> getAllElectionDetails(){
	List<ElectionDetails> list=electionDetailsDao.findAll();
	List<ElectionDetailsDto> list2=new LinkedList<ElectionDetailsDto>();
	for(ElectionDetails e:list) {
		ElectionDetailsDto obj=new ElectionDetailsDto(e.getId(),e.getNameOfElection(), e.getConstituency(), e.getStartDate(), e.getEndDate(), e.getState());
	list2.add(obj);
	}
	return list2;
}

public List<PrevElectionDetailsDto> getPreviousElectionDetails() {
	// TODO Auto-generated method stub
	Date d=new Date();
	System.out.println(d);
	List<ElectionDetails> list=electionDetailsDao.findAll();
	List<PrevElectionDetailsDto> list2=new LinkedList<PrevElectionDetailsDto>();
	for(ElectionDetails e:list) {
		if(e.getEndDate().compareTo(d)<0) {
			System.out.println("I am in If Statement");
			PrevElectionDetailsDto winner=new PrevElectionDetailsDto();
			List<Candidate> list3 =e.getCandidates();
			//List<Candidate> list3 =candidateDao.findByElectionDataId(e.getId());
			for(Candidate c:list3) {
				System.out.println(c.getId() +" "+e.getWinnerVoterId());
				if(c.getId()==e.getWinnerVoterId()) {
					ElectionData ed=c.getElectionData();
					System.out.println(ed.getfName());
					winner.setfName(ed.getfName());
					winner.setlName(ed.getlName());
				    winner.setVoteCount(c.getVoteCount());
				    winner.setConstituency(e.getConstituency());
				    winner.setEndDate(e.getEndDate());
				    winner.setStartDate(e.getStartDate());
				    winner.setParty(c.getParty());
				    winner.setState(e.getState());
				    winner.setNameOfElection(e.getNameOfElection());
				
				}
			}
			list2.add(winner);
		}
		
	}
	return list2;
	

}

public ElectionDetailsDto addElectionDetails(ElectionDetailsDto ed) {
	ElectionDetails e=new ElectionDetails(ed.getNameOfElection(),ed.getConstituency(),ed.getStartDate(),ed.getEndDate(),ed.getState());
	ElectionDetails eReturn=electionDetailsDao.save(e);
	return new ElectionDetailsDto(eReturn.getId(),eReturn.getNameOfElection(),eReturn.getConstituency(),eReturn.getStartDate(),eReturn.getEndDate(),eReturn.getState());
}

public ElectionDetailsDto getTodayElectionDetails(String constituency) {
//	Date d=new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
    Date d = new Date();
    
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(d);
    calendar1.set(Calendar.HOUR_OF_DAY, 0);
    calendar1.set(Calendar.MINUTE, 0);
    calendar1.set(Calendar.SECOND, 0);
    calendar1.set(Calendar.MILLISECOND, 0);
   
    String formattedDate = sdf.format(d);
	System.out.println(formattedDate);
	System.out.println();
	ElectionDetails matching=new ElectionDetails();
	List<ElectionDetails> e=electionDetailsDao.findAll();
	for(ElectionDetails c:e) {
	
		   Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(c.getEndDate());
		    calendar2.set(Calendar.HOUR_OF_DAY, 0);
		    calendar2.set(Calendar.MINUTE, 0);
		    calendar2.set(Calendar.SECOND, 0);
		    calendar2.set(Calendar.MILLISECOND, 0);
		
		if(calendar1.getTime().compareTo(calendar2.getTime())==0 && c.getConstituency().equals(constituency)) {
			System.out.println("Yes");
			matching=c;
		}
	}

	System.out.println();
	return new ElectionDetailsDto( matching.getId(),matching.getNameOfElection(), matching.getConstituency(), matching.getStartDate(), matching.getEndDate(), matching.getState());
}

public Set<String> getElectionNamesList() {
	List<ElectionDetails> list=electionDetailsDao.findAll();
	Set<String> set=new LinkedHashSet<>();
	for(ElectionDetails s:list) {
		set.add(s.getNameOfElection());
	}
	return set;
}

public List<ElectionDetailsDto>getElectionDeatilsByConstituency(String constituency) {
	// TODO Auto-generated method stub
	List<ElectionDetails> list=electionDetailsDao.findByConstituency(constituency);
	List<ElectionDetailsDto> list2=new LinkedList<ElectionDetailsDto>();
	for(ElectionDetails e:list) {
		ElectionDetailsDto edt=new ElectionDetailsDto(e.getId(),e.getNameOfElection(), e.getConstituency(), e.getStartDate(), e.getEndDate(), e.getState());
		list2.add(edt);
	}
	return list2;
}

    @Override
   public List<CandidateDtos> getAllCandidates(long electionId) {
	ElectionDetails electionDetails = electionDetailsDao.findById(electionId);
	List<Candidate> candidateList = electionDetails.getCandidates();
	
	List<CandidateDtos> list = new ArrayList<CandidateDtos>();
	
	for(Candidate c : candidateList ) {
		ElectionData electionData = c.getElectionData();
		list.add(converterDto.toCandidateDtos(c, electionData));
	}
	return list;
 }


public List<ElectionCandidateDto> getElectionCandidateList(long id) {
	ElectionDetails e=electionDetailsDao.findById(id);
	List<Candidate> list1=e.getCandidates();
	List<ElectionCandidateDto> list2=new LinkedList<ElectionCandidateDto>();
	for(Candidate c:list1) {
		ElectionCandidateDto ec=new ElectionCandidateDto(c.getId(),c.getElectionData().getfName(),c.getElectionData().getlName(),c.getParty(),c.getCandidateImage(),c.getPartySymbol(),c.getElectionData().getGender(),c.getVoteCount());
		list2.add(ec);
		
	}
	return list2;
}

@Override
public Optional<ElectionDetails> findElectionDetails(long id) {
	
	
	// TODO Auto-generated method stub
	Optional<ElectionDetails> details =  Optional.ofNullable(electionDetailsDao.findById(id));
	if(details!=null) {
		return details;
	}else {
		return null;
	}
	
	
}









}