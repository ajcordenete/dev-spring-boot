package com.ajcordenete.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "15min daily cricket practice!!!!!";
    }
}
