package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.JobOpportunityDAO;

public class JobOpportunityJUtest {
	
	@Autowired
	JobOpportunityDAO jobopportunityDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobopportunityDAO = (JobOpportunityDAO) context.getBean("jobopportunityDAO");
	}

	@Test
	public void JobOpportunityTestCase()
	{
		int size = jobopportunityDAO.listJobOpportunities().size();
		assertEquals("job oppertunity test case ", 1, size);
	}

}
