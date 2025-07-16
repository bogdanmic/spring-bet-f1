package com.spring.betf1.services;

import com.spring.betf1.persistence.entities.BetEntity;
import com.spring.betf1.persistence.repositories.BetRepository;
import com.spring.betf1.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BettingService {
    private final BetRepository repository;
    private final UserRepository userRepository;

    public boolean placeBet(BetEntity bet){

        var validUser = userRepository.getUser(bet.getDriverId())
                .filter(u->u.getBalance()>= bet.getAmount());
        if(validUser.isEmpty()){
            return false;
        }
        validUser.ifPresent(u->{
            u.setBalance(u.getBalance()- bet.getAmount());
            userRepository.save(u);
            repository.addBet(bet);
        });
        return true;
    }

    public List<BetEntity> getBets(){
        return repository.getAllBets();
    }
}
