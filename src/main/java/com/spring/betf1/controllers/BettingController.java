package com.spring.betf1.controllers;

import com.spring.betf1.dto.EventDto;
import com.spring.betf1.persistence.entities.UserEntity;
import com.spring.betf1.services.EventsService;
import com.spring.betf1.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BettingController {
    private final UsersService usersService;
    private final EventsService eventsService;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return eventsService.getEvents();
    }
}
