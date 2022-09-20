package com.tweetapp;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tweetapp.exception.UserNotExistException;
import com.tweetapp.model.Tweet;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.service.TweetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TweetServiceTest {
    @Mock
    TweetRepository tweetRepository;
    @InjectMocks
    TweetService tweetService;
    @Mock
    UserRepository userRepository;
    
    @Test
    public void testgetAllTweets(){
        List<Tweet> tweets = new ArrayList<Tweet>();
        Tweet tweetOne = new Tweet("1","Srijani","Hello world!!",Arrays.asList("Amrutha","Srijani"),Arrays.asList(),null,null);
        Tweet tweetTwo = new Tweet("2","Amrutha","hey",Arrays.asList("Srijani","Nagarani"),Arrays.asList(),null,null);
        Tweet tweetThree = new Tweet("3","Nagarani","hi",Arrays.asList("Amrutha","Srijani"),Arrays.asList(),null,null);
        tweets.add(tweetOne);
        tweets.add(tweetTwo);
        tweets.add(tweetThree);
        when(tweetRepository.findAll()).thenReturn(tweets);
        List<Tweet> tList = tweetService.getAllTweets();
        assertEquals(3, tList.size());
        Mockito.verify(tweetRepository,times(1)).findAll();
    }
    
    
    @Test
    public void testgetUserTweetsWhenNotAuthorized(){
        List<Tweet> tweets = new ArrayList<Tweet>();
        Tweet tweetOne = new Tweet("1","Srijani","Hello world!!",Arrays.asList("Amrutha","Srijani"),Arrays.asList(),null,null);
        tweets.add(tweetOne);
        when(tweetRepository.findAll()).thenReturn(tweets);
        List<Tweet> tList = tweetService.getAllTweetsOfUser(tweetOne.getUserId());
        assertEquals(0, tList.size());
        
    }
}