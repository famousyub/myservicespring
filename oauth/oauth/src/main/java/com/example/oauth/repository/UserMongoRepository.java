package com.example.oauth.repository;

import com.example.oauth.entity.UserMono;
import com.example.oauth.entity.UserResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserMongoRepository extends MongoRepository<UserMono,String> {
}
