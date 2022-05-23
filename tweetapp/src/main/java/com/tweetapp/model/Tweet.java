package com.tweetapp.model;

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
	private List<String> tweetReplies;
	
	@CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime time;
	
	@LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updatedTime;
	
	
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
	public List<String> getTweetReplies() {
		return tweetReplies;
	}
	public void setTweetReplies(List<String> tweetReplies) {
		this.tweetReplies = tweetReplies;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}
	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", userId=" + userId + ", tweetPost=" + tweetPost + ", likedUsers="
				+ likedUsers + ", tweetReplies=" + tweetReplies + ", time=" + time + ", updatedTime=" + updatedTime
				+ "]";
	}
	public Tweet() {
		super();
	}
	
	
}
