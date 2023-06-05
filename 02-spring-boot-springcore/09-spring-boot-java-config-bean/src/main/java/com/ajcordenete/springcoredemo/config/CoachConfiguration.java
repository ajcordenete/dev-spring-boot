package com.ajcordenete.springcoredemo.config;

import com.ajcordenete.springcoredemo.common.Coach;
import com.ajcordenete.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfiguration {

    @Bean("swimCoach")
    public Coach provideSwimCoach() {
        return new SwimCoach();
    }
}
