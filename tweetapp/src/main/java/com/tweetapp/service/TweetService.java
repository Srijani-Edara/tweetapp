package com.tweetapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.exception.UserNotExistException;
import com.tweetapp.model.Comments;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;

@Service
public class TweetService {
	
	@Autowired
	TweetRepository tweetRepository;
	
	@Autowired
	UserRepository userRepo;
	
	public Tweet addTweet(String loginId, String msg) throws UserNotExistException{
		Users loginIdCheck = userRepo.findByLoginId(loginId);
		if(loginIdCheck == null) {
			throw new UserNotExistException("you need to register ");
		}
		Tweet tweet = new Tweet();
        tweet.setTweetPost(msg);
        tweet.setUserId(loginId);
        tweet.setLikedUsers(new ArrayList<>());
        tweet.setCommentsPosted(new ArrayList<>());
        return tweetRepository.save(tweet);
	}
	
	public List<Tweet> getAllTweets(){
		return tweetRepository.findAll();
	}
	
	public Tweet updateTweet(String tweetId, String updatedTweet) {
		Tweet tweet = tweetRepository.findByTweetId(tweetId);
		tweet.setTweetPost(updatedTweet);
		tweetRepository.save(tweet);
		return tweet;
	}
	
	public void deleteTweet(String tweetId) {
		tweetRepository.deleteById(tweetId);
	}
	
	public List<Tweet> getAllTweetsOfUser(String userId){
		return tweetRepository.findByUserId(userId);
	}
	
	public Tweet likeTweet(String loginId, String tweetId) throws UserNotExistException {
		Users loginIdCheck = userRepo.findByLoginId(loginId);
		if(loginIdCheck == null) {
			throw new UserNotExistException("you need to register ");
		}
		Tweet tweet = tweetRepository.findByTweetId(tweetId);
		List<String> likedUsers = tweet.getLikedUsers();
		
		if (likedUsers.contains(loginId))
			likedUsers.remove(loginId);
		else 
        	likedUsers.add(loginId);
		tweet.setLikedUsers(likedUsers);
		tweetRepository.save(tweet);
		return tweet;
	}
	
	public Tweet replyTweet(String loginId, String tweetId, Comments comment) throws UserNotExistException{
		Users loginIdCheck = userRepo.findByLoginId(loginId);
		if(loginIdCheck == null) {
			throw new UserNotExistException("you need to register ");
		}
		Tweet tweetToUpdate = tweetRepository.findByTweetId(tweetId);
        List<Comments> replyCommentLists = tweetToUpdate.getCommentsPosted();
        comment.setUserId(loginId);
        replyCommentLists.add(comment);
        tweetToUpdate.setCommentsPosted(replyCommentLists);
        return tweetRepository.save(tweetToUpdate);
		
	}
}

