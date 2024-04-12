package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customException.ResourceNotFoundException;
import com.dao.CandidateDao;
import com.dao.ElectionDataDao;
import com.dao.ElectionDetailsDao;
import com.dtos.VotingforCandidateDto;
import com.entities.Candidate;
import com.entities.ElectionData;
import com.entities.ElectionDetails;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CandidateServiceImpl implements CandidateService {
    
    @Autowired
    public CandidateDao candidateDao;

    @Autowired
    public ElectionDataDao electionDataDao;
    
    @Autowired
    public ElectionDetailsDao electionDetailsDao;

    @Override
    public String registerCandidate(Candidate candidate) {
        System.out.println("Candidate service");
        candidateDao.save(candidate);
        return "Save Successfully";
    }

    @Override
    public List<VotingforCandidateDto> getCandidateDetails(VotingforCandidateDto electionVoterId) {
        ElectionData ed = electionDataDao.findByVoterId(electionVoterId.getVoterId());
        ElectionDetails edt = electionDetailsDao.findById(electionVoterId.getElectionDataId()).orElseThrow();
        List<Candidate> cd= edt.getCandidates();
        List<Candidate> list = new ArrayList<Candidate>();
        
        for(Candidate cdt : cd) {
            if(cdt.getElectionData().getConstituency().equals(ed.getConstituency()) && cdt.getStatus().equals("verified")) {
                list.add(cdt);
            }
        }
        
        List<VotingforCandidateDto> vcd = new ArrayList<VotingforCandidateDto>();
        for(Candidate l : list) {
            VotingforCandidateDto vc = new VotingforCandidateDto(l.getElectionData().getfName(), l.getElectionData().getlName(), l.getParty(), l.getCandidateImage(), l.getPartySymbol());
            vcd.add(vc);
        }
        return vcd;
    }

    public String verifyCandidateByAdmin(long candidateId) {
        Candidate candidate = candidateDao.findById(candidateId);
        candidate.setStatus("verified");
        return "candidate verified succesfully";
    }

    @Override
    public String rejectCandidateByAdmin(long candidateId) {
        Candidate candidate = candidateDao.findById(candidateId);
        candidate.setStatus("rejected");
        return "candidate rejected succesfully";
    }
}
