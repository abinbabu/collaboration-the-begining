package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.DAO.JobOpportunityDAO;
import com.niit.model.Blog;
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
	
	
	@GetMapping("/jobs/{jobOpportunityId}")
	public ResponseEntity<JobOpportunity> getJobOpportunity(@PathVariable("jobOpportunityId") String jobOpportunityId) {
		this.jobOpportunity = jobopportunityDAO.getJobOpportunity(jobOpportunityId);
		if (jobOpportunity == null) {
			return new ResponseEntity<JobOpportunity>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<JobOpportunity>(jobOpportunity, HttpStatus.OK);

	}
	
	@PostMapping("/jobs/")
	public ResponseEntity<Void> createJobOpportunity(@RequestBody JobOpportunity jobOpportunity,
			UriComponentsBuilder ucBuilder) {
		if (jobopportunityDAO.getJobOpportunity(jobOpportunity.getJobOpportunityId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		jobopportunityDAO.saveOrUpdateJobOpportunity(jobOpportunity);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/jobs/{jobOpportunityId}/").buildAndExpand(jobOpportunity.getJobOpportunityId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	
	@PutMapping("/jobs/{jobOpportunityId}")
	public ResponseEntity<JobOpportunity> updateJobOpportunity(@PathVariable("jobOpportunityId")String jobOpportunityId,@RequestBody JobOpportunity jobOpportunity){
		
		if(jobOpportunity==null){
			return new ResponseEntity<JobOpportunity>(HttpStatus.NOT_FOUND);
		}
		jobOpportunity.setJobOpportunityId(jobOpportunityId);
		

		
		jobopportunityDAO.saveOrUpdateJobOpportunity(jobOpportunity);

		return new ResponseEntity<JobOpportunity>(jobOpportunity, HttpStatus.OK);

	}
	@DeleteMapping("/jobs/{jobOpportunityId}")
	public ResponseEntity<JobOpportunity> deleteJobOpportunity(@PathVariable("jobOpportunityId")String jobOpportunityId){
	this.jobOpportunity = jobopportunityDAO.getJobOpportunity(jobOpportunityId);
	if(this.jobOpportunity==null){
		System.out.println("jobOpportunity not exist to delete");
		return new ResponseEntity<JobOpportunity>(HttpStatus.NOT_FOUND);
		
	}
	
	jobopportunityDAO.deleteJobOpportunity(jobOpportunityId);
		return new ResponseEntity<JobOpportunity>(HttpStatus.NO_CONTENT);
	
	}
}
