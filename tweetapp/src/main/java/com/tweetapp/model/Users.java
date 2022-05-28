package com.tweetapp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class Users {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String loginId;
	private String password;
	private String mobileNumber;
	
}
