package com.spring.betf1.services.api;

import com.spring.betf1.dto.response.DriverApiResponse;
import com.spring.betf1.dto.response.SessionApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class F1ApiCallerService {

    private final RestTemplate restTemplate;

    @Value("${app.api.sessions.url}")
    private String sessionsUrl;
    @Value("${app.api.drivers.url}")
    private String driversUrl;

    public List<SessionApiResponse> getSessions() {
        var responseEntity =
                restTemplate.exchange(
                        sessionsUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<SessionApiResponse>>() {
                        }
                );

        return responseEntity.getBody();
    }

    public List<DriverApiResponse> getDrivers() {
        var responseEntity =
                restTemplate.exchange(
                        driversUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<DriverApiResponse>>() {
                        }
                );

        return responseEntity.getBody();
    }
}
