package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.AdminData;

public interface AdminDataDao extends JpaRepository<AdminData, Long> {
	public AdminData findByAdminId(String adminId);

}
