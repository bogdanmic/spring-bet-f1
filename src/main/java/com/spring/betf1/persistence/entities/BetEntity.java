package com.spring.betf1.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BetEntity {
    private Integer userId;
    private Integer eventId;
    private Integer driverId;
    private Integer amount;
}
