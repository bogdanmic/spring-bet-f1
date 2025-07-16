package com.spring.betf1.persistence.repositories;

import com.spring.betf1.persistence.entities.BetEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
