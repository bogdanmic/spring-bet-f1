package com.spring.betf1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SessionApiResponse {
    @JsonProperty("session_key")
    private Integer sessionKey;
    private String location;
    @JsonProperty("session_type")
    private String sessionType;
    @JsonProperty("country_name")
    private String country;
    private Integer year;
}
