package com.example.oauth.repository;


import com.example.oauth.entity.UserEntity;
import com.example.oauth.entity.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface UserPollRepository extends JpaRepository<UserResponse,Long> {

    @Query(value = "select username,email,name from  userpoll where username=?1",nativeQuery = true)
    Optional<UserResponse> getUserBuUsername(@Param("username") String username);
}
