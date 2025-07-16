package com.spring.betf1.services.api;

import com.spring.betf1.dto.EventDto;
import com.spring.betf1.dto.response.DriverApiResponse;
import com.spring.betf1.mappers.SessionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiDataProviderService {

    private final F1ApiCallerService apiCallerService;

    @Cacheable("events_data")
    public List<EventDto> getEvents() {
        // Fetch the API Data
        var sessions = apiCallerService.getSessions();
        var driversMap = apiCallerService.getDrivers()
                .stream()
                .collect(Collectors.groupingBy(DriverApiResponse::getSessionKey));
        return sessions.stream()
                .map(s -> SessionMapper.map(
                        s, driversMap.getOrDefault(s.getSessionKey(), Collections.emptyList())
                ))
                .toList();
    }
}
