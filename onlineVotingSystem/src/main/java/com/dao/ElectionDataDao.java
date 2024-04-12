package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.ElectionData;


public interface ElectionDataDao extends JpaRepository<ElectionData, Long> {

	ElectionData findByVoterId(String voterId);
	
	ElectionData findById(long id);
}
