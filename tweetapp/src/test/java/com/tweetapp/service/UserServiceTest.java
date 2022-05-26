package com.tweetapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tweetapp.model.Comment;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.Users;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	
	private Users users1;
	private Users users2;
	private Comment comment1;
	private Comment comment;
	
	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@InjectMocks
	private TweetService tweetService;
	
	Users user;
	Users fetchedUsers;
	
	Tweet tweet;
	Tweet fetchedTweet;
	private LocalDate createdDate;
	
	List<Comment> commentList = new ArrayList<>();
	List likes = new ArrayList<>();
	@BeforeEach
	public void setup() {
		user = new Users("rose","rose","bloom","rose@gmail.com","rose","rose","9087654321");
		userRepository.save(user);
		
		
		
	}
	
	
	/*@Test
	void testAddTweet() throws UserNotExistException {
		userRepository.save(users1);
		tweetRepository.save(tweet);
		Tweet test = tweetService.addTweet("rose","hello");
		//when(tweetRepository.findByTweetId("rose")).thenReturn(tweet);
		assertThat(test.getTweetPost()).isEqualTo(tweet.getTweetPost());
	}*/
	
}
/*@BeforeAll
static void init() {
	List<Comment> commentList = new ArrayList<>();
	comment.setComment("Hey rose!!");
	comment.setUserId("jack");
	
	comment1.setComment("wassup!");
	comment1.setUserId("steve");
	commentList.add(comment);
	commentList.add(comment1);
	
	List<String> l1 = new ArrayList<>();
	l1.add("jack");
	
	tweet.setUserId("rose");
	tweet.setUpdatedDate(LocalDate.of(2022,5,25));
	tweet.setTweetReplies(null);
	tweet.setTweetPost("hello");
	tweet.setTweetId("628f31d2bb4dc731cdd8779b");
	tweet.setLikedUsers(null);
	tweet.setCreatedDate(LocalDate.of(2022,5,25));
	
	users1.setEmail("rose@gmail.com");
	users1.setFirstName("rose");
	users1.setLastName("bloom");
	users1.setLoginId("rose");
	users1.setMobileNumber("9087654321");
	users1.setPassword("rose");
	users1.setUserId("rose");
	
}*/
