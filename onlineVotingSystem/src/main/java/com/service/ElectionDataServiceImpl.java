package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ElectionDataDao;
import com.entities.ElectionData;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ElectionDataServiceImpl implements ElectionDataService {

	
	@Autowired
	private ElectionDataDao electionDataDao;
	
	@Override
	public ElectionData add(ElectionData data) {
		// TODO Auto-generated method stub
		return electionDataDao.save(data);
		
		
	}

}