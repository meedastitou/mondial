package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.EventService;
import com.example.demo.model.Event;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public Event createEvent(@RequestParam("photo") List<MultipartFile> photos, @Valid @RequestPart("data") Event event) {
        event = eventService.setPhotosToEvent(event , photos);
        return eventService.saveEvent(event);
    }


    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{event}")
    public ResponseEntity<Event> getEventById(@PathVariable Event event) {
        return ResponseEntity.ok(event);
    }


    @PutMapping("/{id}")
    public Event updateEvent( @RequestBody Event updatedEvent) {
        return eventService.saveEvent(updatedEvent);
    }

    @DeleteMapping("/{event}")
    public void deleteEvent(@PathVariable Event event) {
    	
        eventService.deleteEvent(event);
    }
    
   
}
