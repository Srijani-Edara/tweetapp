package com.tweetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.AuthRequest;
import com.tweetapp.model.AuthResponse;
import com.tweetapp.service.MyUserDetailsService;
import com.tweetapp.service.UserService;
import com.tweetapp.util.JwtUtil;

@RestController
public class AuthenticationController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    MyUserDetailsService userDetailService;
    
    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public AuthResponse getUserById(@RequestBody AuthRequest aReq) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(aReq.getLoginId(), aReq.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid UserName or Password", e);
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(aReq.getLoginId());
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthResponse response = new AuthResponse();

        response.setJwt(jwt);
        response.setUserId(userDetails.getUsername());
        return response;

    }
    

}

