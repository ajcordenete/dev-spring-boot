package com.ajcordenete.springcoredemo.common;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your butterfly stroke.";
    }
}
