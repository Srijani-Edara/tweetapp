package com.tweetapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	
	
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTweetPost() {
		return tweetPost;
	}
	public void setTweetPost(String tweetPost) {
		this.tweetPost = tweetPost;
	}
	public List<String> getLikedUsers() {
		return likedUsers;
	}
	public void setLikedUsers(List<String> likedUsers) {
		this.likedUsers = likedUsers;
	}
	
	public List<Comment> getTweetReplies() {
		return tweetReplies;
	}
	public void setTweetReplies(List<Comment> tweetReplies) {
		this.tweetReplies = tweetReplies;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public Tweet() {
		super();
	}
	
	
}
