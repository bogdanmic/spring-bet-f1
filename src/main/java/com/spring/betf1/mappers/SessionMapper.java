package com.spring.betf1.mappers;

import com.spring.betf1.dto.EventDto;
import com.spring.betf1.dto.response.DriverApiResponse;
import com.spring.betf1.dto.response.SessionApiResponse;

import java.util.List;

public class SessionMapper {
    public static EventDto map(SessionApiResponse s, List<DriverApiResponse> driverApiResponse) {
        var event = new EventDto();
        event.setId(s.getSessionKey());
        event.setName(s.getLocation());
        event.setType(s.getSessionType());
        event.setCountry(s.getCountry());
        event.setYear(s.getYear());
        event.setDrivers(
                driverApiResponse.stream()
                        .map(DriverMapper::map)
                        .toList()
        );
        return event;
    }
}
