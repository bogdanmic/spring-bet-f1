package com.spring.betf1.services;

import com.spring.betf1.dto.EventDto;
import com.spring.betf1.services.api.ApiDataProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventsService {

    private final ApiDataProviderService apiDataProviderService;

    public List<EventDto> getEvents() {
        // Fetch the API Data from Cache
        return apiDataProviderService.getEvents();
    }
}
