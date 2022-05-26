package com.tweetapp.exception;

public class UserNotExistException extends Exception {
		public UserNotExistException(String errorMessage) {
	        super(errorMessage);
	    }
}
