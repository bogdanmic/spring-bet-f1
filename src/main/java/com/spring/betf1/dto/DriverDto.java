package com.spring.betf1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DriverDto {
    private Integer id;
    private String name;
    private Integer odds;
}
