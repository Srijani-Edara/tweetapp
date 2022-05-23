package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{

    public Users findByLoginId(String loginId);

    public Users findByEmail(String email);

    @Query("{'loginId':{'$regex':?0, $options:'i'}}")
    public List<Users> searchByName(String loginId);
}
