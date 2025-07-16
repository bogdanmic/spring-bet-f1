package com.spring.betf1.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    private Integer id;
    private Integer balance = 100;
}
