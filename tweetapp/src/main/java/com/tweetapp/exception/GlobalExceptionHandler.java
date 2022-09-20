package com.tweetapp.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorMsg error = new ErrorMsg("Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(UserAlreadyExistException.class)
    public final ResponseEntity<Object> userAlreadyExistException(UserAlreadyExistException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorMsg error = new ErrorMsg("user already exists", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(UserNotExistException.class)
    public final ResponseEntity<Object> userNotExistException(UserNotExistException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorMsg error = new ErrorMsg("user not exists", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
	
	
	
}
