package com.spring.betf1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventDto {
    private Integer id;
    private String name;
    private String type;
    private String country;
    private Integer year;
    private List<DriverDto> drivers;
}
