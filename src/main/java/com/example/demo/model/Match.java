package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;




@Data
@Builder
@Document(collection = "Match")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {

    @Id
    private String matchId;
    @NotNull(message = "stade can't be null")
    private String stade;
    private LocalDateTime dateTime;
    @DBRef
    private Equipe equipe1;
    @DBRef
    private Equipe equipe2;
    private Integer score_equipe1;
    private Integer score_equipe2;
    private MatchStatus status;
    private List<EvenementMatch> evenements;
    

    
}
