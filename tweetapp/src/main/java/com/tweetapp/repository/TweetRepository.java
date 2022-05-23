package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Tweet;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String>{
	
	public Tweet findByTweetId(String tweetId);
	
	public List<Tweet> findByUserId(String userId);
	
}