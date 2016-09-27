package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.EventDAO;
import com.niit.model.Event;

@RestController
public class EventController {
	
	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	Event event;
	
	@GetMapping("/events/")
	public ResponseEntity<List<Event>> listAllEvents() {
		List<Event> listOfEvents = eventDAO.listEvents();
		if (listOfEvents.isEmpty()) {
			return new ResponseEntity <List<Event>> (HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity < List < Event >> (listOfEvents, HttpStatus.OK);
	}

}
