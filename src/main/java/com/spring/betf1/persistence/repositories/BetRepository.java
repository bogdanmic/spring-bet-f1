package com.spring.betf1.persistence.repositories;

import com.spring.betf1.persistence.entities.BetEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BetRepository {
    private List<BetEntity> bets;

    public List<BetEntity> getAllBets(){
        return  bets;
    }
    public boolean addBet(BetEntity bet){
        if(bets == null){
            bets = new ArrayList<>();
        }
        return  bets.add(bet);
    }

    public void deleteBetsForEvent(Integer eventId){
        if(bets == null){
            bets = new ArrayList<>();
        }
       bets = bets.stream()
               .filter(b-> !Objects.equals(b.getEventId(), eventId))
               .collect(Collectors.toList());
    }

}
