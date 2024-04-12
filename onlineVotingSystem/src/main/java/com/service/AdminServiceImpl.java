package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.AdminDataDao;
import com.dao.CandidateDao;
import com.dao.ElectionDataDao;
import com.dao.ElectionDetailsDao;
import com.dtos.WinnerDto;
import com.entities.AdminData;
import com.entities.Candidate;
import com.entities.ElectionData;
import com.entities.ElectionDetails;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDataDao adminDataDao;

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private ElectionDetailsService electioDetailsService;

	@Autowired
	private ElectionDetailsDao electionDetailsDao;

	@Autowired
	private ElectionDataDao electionDataDao;

	@Override
	public AdminData adminSignInService(AdminData adminData) {
		AdminData adminDatas = adminDataDao.findByAdminId(adminData.getAdminId());
		if (adminData.getAdminId().equals(adminDatas.getAdminId())
				&& adminData.getPassword().equals(adminDatas.getPassword())) {
			return adminDatas;
		}
		return null;
	}

	

}