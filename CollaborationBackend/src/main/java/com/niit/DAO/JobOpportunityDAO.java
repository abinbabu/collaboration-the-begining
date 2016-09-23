package com.niit.DAO;

import java.util.List;

import com.niit.model.JobOpportunity;

public interface JobOpportunityDAO {
	
	void saveOrUpdateJobOpportunity(JobOpportunity jobOpportunity);
	
	void deleteJobOpportunity(String jobOpportunityId);
	
	JobOpportunity getJobOpportunity(String jobOpportunityId);
	
	List<JobOpportunity> listJobOpportunities();

}
