package com.tweetapp.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


public class ErrorMsg {
	

    private String message;

    private List<String> details;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
    
    public ErrorMsg(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
}


