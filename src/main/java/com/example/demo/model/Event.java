package com.example.demo.model;


import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("event")
public class Event {
	
	
	@Id
	private String id;
	
	private String nom;
	
	private String description;
	
	private String Lieu;
	
	private Date date;
	
	private List<byte[]> photos;
	
	private Ville ville;
}
