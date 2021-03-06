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

import com.niit.DAO.EventDAO;
import com.niit.model.Blog;
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
	
	@GetMapping("/events/{eventId}")
	public ResponseEntity<Event> getEvent(@PathVariable("eventId") String eventId) {
		this.event = eventDAO.getEvent(eventId);
		if (event == null) {
			return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Event>(event, HttpStatus.OK);

	}
	
	
	@PostMapping("/events/")
	public ResponseEntity<Void> createEvent(@RequestBody Event event,
			UriComponentsBuilder ucBuilder) {
		if (eventDAO.getEvent(event.getEventId()) != null) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}

		/*
		 * role.setId("ROLE_USER"); role.setName("ROLE_USER");
		 */
		eventDAO.saveOrUpdateEvent(event);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("events/{eventId}").buildAndExpand(event.getEventId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}
	
	@PutMapping("/events/{eventId}")
	public ResponseEntity<Event> updateEvent(@PathVariable("eventId")String eventId,@RequestBody Event event){
		
		if(event==null){
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
		event.setEventId(eventId);
		

		
		eventDAO.saveOrUpdateEvent(event);

		return new ResponseEntity<Event>(event, HttpStatus.OK);

	}
	
	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("eventId")String eventId){
	this.event = eventDAO.getEvent(eventId);
	if(this.event==null){
		System.out.println("event not exist to delete");
		return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		
	}
	
		eventDAO.deleteEvent(eventId);
		return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
	
	}

}
