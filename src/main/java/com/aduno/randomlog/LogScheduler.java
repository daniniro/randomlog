package com.aduno.randomlog;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LogScheduler {
    private LogEmitter logEmitter;

    @Autowired
    public LogScheduler(LogEmitter emitter) {
        this.logEmitter = emitter;
    }

    @Scheduled(cron = "${scheduling.job.cron}")
    public void schedule() {

        MDC.put("correlation_id", UUID.randomUUID().toString());

        logEmitter.randomLog();
    }
}
