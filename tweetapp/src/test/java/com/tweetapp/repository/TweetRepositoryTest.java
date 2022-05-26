package com.tweetapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.tweetapp.model.Comment;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;


public class TweetRepositoryTest {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	Users user;
	Users fetchedUsers;
	
	Tweet tweet;
	Tweet fetchedTweet;
	
	List<Comment> commentList = new ArrayList<>();
	List likes = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		tweet = new Tweet("628e15a5a1ccfb457629f446","rose","Hello world!!",likes,commentList,LocalDate.of(2022,5,25),LocalDate.of(2022,5,25));
		tweetRepository.save(tweet);
	}
	
	@Test
	void testFindByTweetId() {
		fetchedTweet = tweetRepository.findByTweetId(tweet.getTweetId());
		assertThat(fetchedTweet.getTweetPost()).isEqualTo(tweet.getTweetPost());
	}
	
	@Test
	void testFindByUserId() {
		List<Tweet> fetchedTweets = tweetRepository.findByUserId(tweet.getUserId());
		assertThat(fetchedTweets.size()).isEqualTo(1);
	}

}
