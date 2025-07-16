package com.spring.betf1.controllers;

import com.spring.betf1.dto.EventDto;
import com.spring.betf1.dto.SettleBetDto;
import com.spring.betf1.persistence.entities.BetEntity;
import com.spring.betf1.persistence.entities.UserEntity;
import com.spring.betf1.services.BettingService;
import com.spring.betf1.services.EventsService;
import com.spring.betf1.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BettingController {
    private final UsersService usersService;
    private final EventsService eventsService;
    private final BettingService bettingService;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return eventsService.getEvents();
    }

    @GetMapping("/bets")
    public List<BetEntity> getBets() {
        return bettingService.getBets();
    }

    @PostMapping("/bets")
    public BetEntity placeBet(@RequestBody BetEntity bet) {
         if(bettingService.placeBet(bet)){
             log.info("The bet: {} was placed successfully",bet);
         }else{
             log.warn("The bet: {} was not placed",bet);
         }
         return bet;
    }

    @PostMapping("/settle")
    public SettleBetDto placeBet(@RequestBody SettleBetDto settlement) {
        bettingService.settleBets(settlement);
        return settlement;
    }
}
