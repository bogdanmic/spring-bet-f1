package com.spring.betf1.persistence.repositories;

import com.spring.betf1.persistence.entities.UserEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository {
    private List<UserEntity> users;

    @PostConstruct
    private void init(){
        // Initialize the in memory database
        users=List.of(
            new UserEntity(1,100),
            new UserEntity(2,100),
            new UserEntity(3,100),
            new UserEntity(4,100)
        );
    }

    public List<UserEntity> getAllUsers(){
        return  users;
    }
}
