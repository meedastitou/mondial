package com.example.demo.Exception;

public class MatchException extends Exception{
    private static final long serialVersionUID = 1L;

	public MatchException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Match with "+id+" not found!";
	}
}
