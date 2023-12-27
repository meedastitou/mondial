package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Event;

public interface EventService {
	
	public Event saveEvent(Event event);
	
	public Event getById(String id) ;
	
	public List<Event> getAllEvents();
	
	public void deleteEvent(Event event) ;
}
