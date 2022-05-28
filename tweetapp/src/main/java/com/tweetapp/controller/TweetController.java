package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.exception.UserNotExistException;
import com.tweetapp.model.Comment;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.TweetMsg;
import com.tweetapp.service.TweetService;

import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/tweets")
@CrossOrigin("*")
@Slf4j
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	
	@GetMapping("/all")
	public List<Tweet> allTweets(){
		log.info("fetching all tweets");
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/{loginId}")
	public List<Tweet> allTweetsOfUser(@PathVariable("loginId") String loginId){
		log.info("fetching tweets of a user");
		return tweetService.getAllTweetsOfUser(loginId);
	}
	
	@PostMapping("/{loginId}/add")
	public Boolean postTweet(@PathVariable("loginId") String loginId, @RequestBody TweetMsg tweet) {
		try {
			log.info("adding tweet");
			tweetService.addTweet(loginId, tweet.getTweetMsg());
			return true;
		}
		catch(UserNotExistException e) {
			return false;
		}
		
	}
	
	@PutMapping("/{loginId}/update/{tweetId}")
	public Tweet updateTweet(@PathVariable("loginId") String loginId, @PathVariable String tweetId, @RequestBody TweetMsg tweet) {
		log.info("updating a tweet");
		return tweetService.updateTweet(tweetId, tweet.getTweetMsg());
	}
	
	@DeleteMapping("/{loginId}/delete/{tweetId}")
	public Boolean deleteTweet(@PathVariable("loginId") String loginId, @PathVariable String tweetId) {
		log.info("deleting a tweet");
		tweetService.deleteTweet(tweetId);
		return true;
	}
	
	@PutMapping("/{loginId}/like/{tweetId}")
	public Boolean likeTweet(@PathVariable("loginId") String loginId, @PathVariable String tweetId) {
		try {
			log.info("liking a tweet");
			tweetService.likeTweet(loginId, tweetId);
			return true;
		}
		catch (UserNotExistException e) {
            return false;
        }
		
	}
	
	@PutMapping("/{loginId}/reply/{tweetId}")
	public boolean replyTweet(@PathVariable("loginId") String loginId, @PathVariable String tweetId, @RequestBody Comment comment) {
		try {
			log.info("commenting a tweet");
			tweetService.replyTweet(loginId, tweetId, comment);
			return true;
		}
		catch(UserNotExistException e) {
			return false;
		}
		
		
		
	}

}

