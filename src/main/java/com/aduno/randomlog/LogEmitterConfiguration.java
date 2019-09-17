package com.aduno.randomlog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class LogEmitterConfiguration {

    @Bean
    public SLF4JLogEmitter logEmitter() {
        return new SLF4JLogEmitter();
    }
}
