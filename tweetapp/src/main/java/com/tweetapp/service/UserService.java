package com.tweetapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetapp.exception.UserAlreadyExistException;
import com.tweetapp.model.AuthRequest;
import com.tweetapp.model.Users;
import com.tweetapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Users> getUserById(String name) {
        List<Users> userList = userRepository.searchByName(name);
        return userList;
    }
    
    public Users signUpUser(Users user) throws UserAlreadyExistException {
        Users emailCheck = userRepository.findByEmail(user.getEmail());
        Users loginIdCheck = userRepository.findByLoginId(user.getLoginId());
        if (emailCheck != null) {
            throw new UserAlreadyExistException("Email Already exist. change to new Email");
        }
        if (loginIdCheck != null) {
            throw new UserAlreadyExistException("LoginId Already exist. change to new Login Id");
        }

        return userRepository.save(user);

    }
    
    public Users forgetPassword(AuthRequest aReq) {
        Users fetcheduser = userRepository.findByLoginId(aReq.getLoginId());
        if (fetcheduser == null) {
            throw new UsernameNotFoundException("INVALID USER NAME");
        }
        fetcheduser.setPassword(aReq.getPassword());
        return userRepository.save(fetcheduser);
    }

}

