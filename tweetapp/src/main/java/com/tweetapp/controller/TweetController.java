package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Tweet;
import com.tweetapp.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	
	@GetMapping("/all")
	public List<Tweet> allTweets(){
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/{loginId}")
	public List<Tweet> allTweetsOfUser(@PathVariable String loginId){
		return tweetService.getAllTweetsOfUser(loginId);
	}
	
	@PostMapping("/{loginId}/add")
	public Boolean postTweet(@PathVariable String loginId, @RequestBody String tweet) {
		tweetService.addTweet(loginId, tweet);
		return true;
	}
	
	@PutMapping("/{loginId}/update/{tweetId}")
	public Tweet updateTweet(@PathVariable String loginId, @PathVariable String tweetId, @RequestBody String tweet) {
		return tweetService.updateTweet(tweetId, tweet);
	}
	
	@DeleteMapping("/{loginId}/delete/{tweetId}")
	public Boolean deleteTweet(@PathVariable String loginId, @PathVariable String tweetId) {
		tweetService.deleteTweet(tweetId);
		return true;
	}
	
	@PutMapping("/{loginId}/like/{tweetId}")
	public Tweet likeTweet(@PathVariable String loginId, @PathVariable String tweetId) {
		return tweetService.likeTweet(loginId, tweetId);
	}
	
	@PutMapping("/{loginId}/reply/{tweetId}")
	public Tweet replyTweet(@PathVariable String loginId, @PathVariable String tweetId, @RequestBody String comment) {
		return tweetService.replyTweet(loginId, tweetId, comment);
	}

}

