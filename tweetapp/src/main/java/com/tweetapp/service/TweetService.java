package com.tweetapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.Tweet;
import com.tweetapp.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	TweetRepository tweetRepository;
	
	public Tweet addTweet(String loginId, String msg) {
		Tweet tweet = new Tweet();
        tweet.setTweetPost(msg);
        tweet.setUserId(loginId);
        tweet.setLikedUsers(new ArrayList<>());
        tweet.setTweetReplies(new ArrayList<>());
        return tweetRepository.save(tweet);
	}
	
	public List<Tweet> getAllTweets(){
		return tweetRepository.findAll();
	}
	
	public Tweet updateTweet(String tweetId, String updatedTweet) {
		Tweet tweet = tweetRepository.findByTweetId(tweetId);
		tweet.setTweetPost(updatedTweet);
		return tweet;
	}
	
	public void deleteTweet(String tweetId) {
		tweetRepository.deleteById(tweetId);
	}
	
	public List<Tweet> getAllTweetsOfUser(String userId){
		return tweetRepository.findByUserId(userId);
	}
	
	public Tweet likeTweet(String loginId, String tweetId) {
		Tweet tweet = tweetRepository.findByTweetId(tweetId);
		List<String> likedUsers = tweet.getLikedUsers();
		
		if (likedUsers.contains(loginId))
			likedUsers.remove(loginId);
		else 
        	likedUsers.add(loginId);
		tweet.setLikedUsers(likedUsers);
		return tweet;
	}
	
	public Tweet replyTweet(String loginId, String tweetId, String tweetReply) {
		Tweet tweet = tweetRepository.findByTweetId(tweetId);
		List<String> replies = tweet.getTweetReplies();
		replies.add(tweetReply);
		tweet.setTweetReplies(replies);
		return tweet;
	}
}

