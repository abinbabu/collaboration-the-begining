package com.niit.DAO;

import java.util.List;

import com.niit.model.Event;

public interface EventDAO {
	
	void saveOrUpdateEvent(Event event);
	
	void deleteEvent(String eventId);
	
	Event getEvent(String eventId);
	
	List<Event> listEvents();

}
