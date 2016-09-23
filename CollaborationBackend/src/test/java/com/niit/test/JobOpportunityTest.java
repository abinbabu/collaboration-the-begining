package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.JobOpportunityDAO;
import com.niit.model.JobOpportunity;



public class JobOpportunityTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		JobOpportunityDAO jobopportunityDAO = (JobOpportunityDAO) context.getBean("jobopportunityDAO");
		JobOpportunity jobopportunity = (JobOpportunity) context.getBean("jobOpportunity");
		
		jobopportunity.setJobOpportunityId("jb1");
		jobopportunity.setContent("no job now no job now no job now");
		jobopportunity.setDateTime(new Date(System.currentTimeMillis()));
		
		jobopportunityDAO.saveOrUpdateJobOpportunity(jobopportunity);
		
		if(jobopportunityDAO.getJobOpportunity("jb1")== null)
		{
			System.out.println("job opportunity does not exist");
		}
		else
		{
			System.out.println("job opportunity exists..");
			System.out.println();
		} 
	}

}
