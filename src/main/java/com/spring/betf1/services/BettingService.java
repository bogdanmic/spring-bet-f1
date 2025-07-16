package com.spring.betf1.services;

import com.spring.betf1.dto.SettleBetDto;
import com.spring.betf1.persistence.entities.BetEntity;
import com.spring.betf1.persistence.repositories.BetRepository;
import com.spring.betf1.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BettingService {
    private final BetRepository repository;
    private final UserRepository userRepository;
    private final EventsService eventsService;

    public boolean placeBet(BetEntity bet) {

        var validUser = userRepository.getUser(bet.getUserId())
                .filter(u -> u.getBalance() >= bet.getAmount());
        if (validUser.isEmpty()) {
            return false;
        }
        validUser.ifPresent(u -> {
            u.setBalance(u.getBalance() - bet.getAmount());
            userRepository.save(u);
            repository.addBet(bet);
        });
        return true;
    }

    public List<BetEntity> getBets() {
        return repository.getAllBets();
    }

    public void settleBets(SettleBetDto settlement) {
        // Find the odds for the event
        var winningOdd = eventsService.getWinningOdd(settlement.getEventId(), settlement.getWinnerDriverId());
        if (winningOdd.isEmpty()) {
            log.error("No event data found for {} settlement", settlement);
            return;
        }
        // settle the winning bets
        repository.getAllBets().stream()
                // find the winning bets
                .filter(b -> Objects.equals(b.getEventId(), settlement.getEventId()) && Objects.equals(b.getDriverId(), settlement.getWinnerDriverId()))
                .forEach(wb -> collectWinnings(wb, winningOdd.get()));

        // delete the bets for the settled event
        repository.deleteBetsForEvent(settlement.getEventId());
    }

    private void collectWinnings(BetEntity bet, Integer odds) {

        var validUser = userRepository.getUser(bet.getUserId());
        if (validUser.isEmpty()) {
            return;
        }
        validUser.ifPresent(u -> {
            u.setBalance(u.getBalance() + bet.getAmount() * odds);
            userRepository.save(u);
        });
    }
}
