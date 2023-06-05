package com.ajcordenete.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach() {
        System.out.println("in constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k daily!";
    }

    @PostConstruct
    private void doSomeStuffAfterInitialization() {
        System.out.println("after initialization: " + getClass().getSimpleName());
    }

    @PreDestroy
    private void doSomeStuffBeforeDestroy() {
        System.out.println("before destroy: " + getClass().getSimpleName());
    }
}
