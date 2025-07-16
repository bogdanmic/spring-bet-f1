package com.spring.betf1.utils;

import java.util.Random;

public class OddsGenerator {
    public static Integer generateOdds() {
        Random r = new Random();
        int low = 2;
        int high = 5;
        return r.nextInt(high - low) + low;
    }
}
