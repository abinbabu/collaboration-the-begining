package com.niit.JUtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.EventDAO;

public class EventJUtest {

	@Autowired
	EventDAO eventDAO;
	
AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		eventDAO = (EventDAO) context.getBean("eventDAO");
	}
	
	@Test
	public void EventTestCase()
	{
		int size = eventDAO.listEvents().size();
		assertEquals("event list test case ", 2, size);
	}
}
