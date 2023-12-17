package com.example.demo.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

  public ErrorResponse(String message, List<String> details) {
    super();
    this.message = message;
    this.details = details;
  }

  //General error message about nature of error
  private String message;

  //Specific errors in API request processing
  private List<String> details;
}