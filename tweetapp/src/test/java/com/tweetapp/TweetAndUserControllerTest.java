package com.tweetapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.controller.TweetController;
import com.tweetapp.model.TweetMsg;
import com.tweetapp.service.TweetService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
public class TweetAndUserControllerTest {
	
    private MockMvc mockMvc;
    @Mock
    TweetService tweetService;
    @InjectMocks
    TweetController tweetController;
    
    @BeforeEach
    void setupEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(tweetController).build();
    }
    @Test
    public void testPostTweet() throws JsonProcessingException, Exception{
        String loginId = "Srijani";
        TweetMsg tweetDetail = new TweetMsg();
        tweetDetail.setTweetMsg("helo");
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/tweets/{​loginId}​/add",loginId).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(tweetDetail))).andReturn();
        assertEquals(HttpStatus.OK.value(), response.getResponse().getStatus());
        }
    
    @Test
    public void testgetTweet() throws Exception{
        String loginId = "Srijani";
        MvcResult response1 = mockMvc.perform(MockMvcRequestBuilders.get("/{loginId}",loginId).accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(404, response1.getResponse().getStatus());
        }
    
    @Test
    public void testUpdateTweet() throws Exception {
        String loginId = "Srijani";
        String tweetId = "1234";
        TweetMsg tweetDetail = new TweetMsg();
        tweetDetail.setTweetMsg("helo");
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.delete("/{loginId}/delete/{tweetId}",loginId,tweetId).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(404, response.getResponse().getStatus());
        }
}
    
    
  
  
