package com.ajcordenete.springcoredemo.rest;


import com.ajcordenete.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public DemoRestController(
            @Qualifier("trackCoach") Coach myCoach,
            @Qualifier("trackCoach") Coach otherCoach
    ) {
        System.out.println("in constructor " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = otherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkInstance() {
        return "Comparing beans: " + (this.myCoach == this.anotherCoach);
    }
}
