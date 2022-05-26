package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.exception.UserAlreadyExistException;
import com.tweetapp.model.AuthRequest;
import com.tweetapp.model.Users;
import com.tweetapp.service.MyUserDetailsService;
import com.tweetapp.service.UserService;
import com.tweetapp.util.JwtUtil;

@RestController
@RequestMapping("/tweetapp")
@CrossOrigin("*")
public class UserController {
	 @Autowired
	 UserService userService;

	 @Autowired
	 MyUserDetailsService userDetailService;

	 @Autowired
	 AuthenticationManager authenticationManager;

	 @Autowired
	 JwtUtil jwtUtil;

	 @PostMapping("/signup")
	 public Boolean signUpUser(@RequestBody Users user) throws UserAlreadyExistException {
	     try {
	           userService.signUpUser(user);
	        } catch (UserAlreadyExistException e) {
	            return false;
	        }
	        return true;
	  }

	 @GetMapping("/user/all")
	 public List<Users> getAllUsers() {
	     List<Users> userList = userService.getAllUsers();
	     return userList;
	 }

	 @GetMapping("/user/{userName}")
	    public List<Users> getUserById(@PathVariable("userName") String userName) {
	     return userService.getUserById(userName);
	 }

	 @PutMapping("/user/forgetpassword")
	 public Boolean getUserById(@RequestBody AuthRequest aReq) throws Exception {
	 try {
	        userService.forgetPassword(aReq);
	     } catch (UsernameNotFoundException e) {
	        return false;

	     }

	       return true;
	    }

	}
