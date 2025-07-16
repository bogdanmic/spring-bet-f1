package com.spring.betf1.services;

import com.spring.betf1.dto.DriverDto;
import com.spring.betf1.dto.EventDto;
import com.spring.betf1.services.api.ApiDataProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventsService {

    private final ApiDataProviderService apiDataProviderService;

    public List<EventDto> getEvents() {
        // Fetch the API Data from Cache
        return apiDataProviderService.getEvents();
    }

    public Optional<Integer> getWinningOdd(Integer eventId, Integer winnerDriverId) {
        return apiDataProviderService.getEvents().stream()
                .filter(e -> Objects.equals(e.getId(), eventId))
                .flatMap(e -> e.getDrivers().stream())
                .filter(d -> Objects.equals(d.getId(), winnerDriverId))
                .map(DriverDto::getOdds)
                .findAny();
    }
}
