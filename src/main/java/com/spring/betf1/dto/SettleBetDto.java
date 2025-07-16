package com.spring.betf1.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SettleBetDto {
    private Integer userId;
    private Integer eventId;
    private Integer id;
    private Integer amount;
}
