package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.JobOpportunityDAO;
import com.niit.model.JobOpportunity;

@RestController
public class JobOpportunityController {
	
	@Autowired
	JobOpportunity jobOpportunity;
	
	@Autowired
	JobOpportunityDAO jobopportunityDAO;
	
	@GetMapping("/jobs/")
	public ResponseEntity<List<JobOpportunity>> listAllJobOpportunity() {
		List<JobOpportunity> listOfJobOpportunity = jobopportunityDAO.listJobOpportunities();
		if (listOfJobOpportunity.isEmpty()) {
			return new ResponseEntity <List<JobOpportunity>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < JobOpportunity >> (listOfJobOpportunity, HttpStatus.OK);
	}
	
	

}
