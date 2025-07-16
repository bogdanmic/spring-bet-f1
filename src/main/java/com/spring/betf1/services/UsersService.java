package com.spring.betf1.services;

import com.spring.betf1.persistence.entities.UserEntity;
import com.spring.betf1.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {
    private final UserRepository repository;

    public List<UserEntity> getUsers(){
        return repository.getAllUsers();
    }
}
