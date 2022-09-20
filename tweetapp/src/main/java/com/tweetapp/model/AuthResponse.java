package com.tweetapp.model;

import lombok.Data;

@Data
public class AuthResponse {
	String userId;
    String jwt;
}

