package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.EventDAO;
import com.niit.model.Event;



public class EventTest {

	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAO");
		Event event = (Event) context.getBean("event");
		
		event.setEventId("ev2");
		event.setContent("today is holy day for niit");
		event.setDateTime(new Date(System.currentTimeMillis()));
		eventDAO.saveOrUpdateEvent(event);
		
		if(eventDAO.getEvent("ev1")== null)
		{
			System.out.println("event does not exist");
		}
		else
		{
			System.out.println("event exists..");
			System.out.println();
		} 
		
		

	}

}
