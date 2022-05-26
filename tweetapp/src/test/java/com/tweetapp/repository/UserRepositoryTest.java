package com.tweetapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tweetapp.model.Users;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	Users user;
	Users fetchedUsers;
	
	@BeforeEach
	public void setup() {
		user = new Users("rose","rose","bloom","rose@gmail.com","rose","rose","9087654321");
		userRepository.save(user);
	}
	
	@Test
	void testUserByLoginId() {
		fetchedUsers = userRepository.findByLoginId(user.getLoginId());
		assertThat(user.getLoginId()).isEqualTo(fetchedUsers.getLoginId());
	}
	
	@Test
	void testUserByEmail() {
		fetchedUsers = userRepository.findByEmail(user.getEmail());
		assertThat(user.getUserId()).isEqualTo(fetchedUsers.getUserId());
	}
	
	@Test
	void testSearchByName() {
		List<Users> users = userRepository.searchByName(user.getLoginId());
		assertThat(1).isEqualTo(users.size());
	}
	
	
}
