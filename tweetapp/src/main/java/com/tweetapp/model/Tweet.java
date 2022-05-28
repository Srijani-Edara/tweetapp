package com.tweetapp.model;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tweets")
public class Tweet {
	@Id
	private String tweetId;
	private String userId;
	private String tweetPost;
	private List<String> likedUsers;
	private List<Comment> tweetReplies;
	
	@CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;
}
