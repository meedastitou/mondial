package com.example.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

	@NotBlank(message = "nom must be not null")
	@Size(min = 3, message = "nom must be more then 3 charachter")
	private String nom;

	@NotBlank(message = "description must be not null")
	@Size(min = 3, message = "description must be more then 3 charachter")
	private String description;

	@NotBlank(message = "lieu must be not null")
	@Size(min = 3, message = "lieu must be more then 3 charachter")
	private String lieu;

	@NotNull
	@DateTimeFormat(style = "yyyy-MM-dd hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date date;

	
	private List<byte[]> photos;

	@DBRef
	private Ville ville;
}
