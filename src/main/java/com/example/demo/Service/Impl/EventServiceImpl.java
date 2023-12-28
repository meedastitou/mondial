package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.EventService;
import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public Event getById(String id) {
		return eventRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error: The Event is not found."));
	}
	
	public List<Event> getAllEvents()
	{
		return eventRepository.findAll();
	}
	
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	
	public Event setPhotosToEvent(Event event, List<MultipartFile> photos ){
		List<byte[]>  photoByte = new ArrayList<>();
		for (MultipartFile photo : photos) {
			try {
				photoByte.add(photo.getBytes());
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		event.setPhotos(photoByte);

		return event;
	}
}
