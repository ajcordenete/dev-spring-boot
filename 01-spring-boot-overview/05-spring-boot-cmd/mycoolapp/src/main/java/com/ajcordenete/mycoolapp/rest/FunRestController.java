package com.ajcordenete.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //Inject properties for coach.name and team.name
    @Value("${coach.name}")
    public String coachName;

    @Value("${team.name}")
    public String teamName;

    // expose new endpoint for teamInfo
    @GetMapping("/team")
    public String getTeamInfo() {
        return "Coach:" + coachName + ", Team:" + teamName;
    }

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    // expose a new endpoint for workout
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
