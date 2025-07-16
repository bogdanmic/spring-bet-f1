package com.spring.betf1.mappers;

import com.spring.betf1.dto.DriverDto;
import com.spring.betf1.dto.EventDto;
import com.spring.betf1.dto.response.DriverApiResponse;
import com.spring.betf1.dto.response.SessionApiResponse;
import com.spring.betf1.utils.OddsGenerator;

import java.util.List;

public class DriverMapper {

    public static DriverDto map(DriverApiResponse d) {
        var driver = new DriverDto();
        driver.setId(d.getDriverNumber());
        driver.setName(d.getName());
        driver.setOdds(OddsGenerator.generateOdds());
        return driver;
    }
}
