package com.spring.betf1.persistence.repositories;

import com.spring.betf1.persistence.entities.UserEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserRepository {
    private Map<Integer, UserEntity> users;

    @PostConstruct
    private void init() {
        // Initialize the in memory database
        users = new HashMap<>();
        users.put(1, new UserEntity(1, 100));
        users.put(2, new UserEntity(2, 100));
        users.put(3, new UserEntity(3, 100));
        users.put(4, new UserEntity(4, 100));
    }

    public List<UserEntity> getAllUsers() {
        return users.values().stream().toList();
    }

    public Optional<UserEntity> getUser(Integer id) {
        return Optional.of(users)
                .map(u -> u.get(id));
    }

    public void save(UserEntity user) {
        users.put(user.getId(), user);
    }
}
