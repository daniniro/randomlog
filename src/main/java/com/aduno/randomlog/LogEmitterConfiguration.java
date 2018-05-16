package com.aduno.randomlog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class LogEmitterConfiguration {
    @Bean
    public LogEmitter logEmitter(){
        return new LogEmitter();
    }
}
