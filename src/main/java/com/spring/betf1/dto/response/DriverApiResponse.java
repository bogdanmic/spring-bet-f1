package com.spring.betf1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DriverApiResponse {
    @JsonProperty("session_key")
    private Integer sessionKey;
    @JsonProperty("driver_number")
    private Integer driverNumber;
    @JsonProperty("full_name")
    private String name;
}
