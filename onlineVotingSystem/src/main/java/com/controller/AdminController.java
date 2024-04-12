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

import com.entities.AdminData;
import com.service.AdminServiceImpl;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	    @Autowired
        private  AdminServiceImpl adminService;
	    

	    
	    @PostMapping("/signin")
	    public ResponseEntity<AdminData> adminSignIn(@RequestBody AdminData adminData) {
	    	   return ResponseEntity.ok(adminService.adminSignInService(adminData));
	    }
	    
	    
	   
}
