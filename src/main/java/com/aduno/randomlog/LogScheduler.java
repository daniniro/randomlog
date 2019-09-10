package com.aduno.randomlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LogScheduler {
    private LogEmitter SLF4JLogEmitter;

    @Autowired
    public LogScheduler(LogEmitter emitter) {
        this.SLF4JLogEmitter = emitter;
    }

    @Scheduled(cron = "${scheduling.job.cron}")
    public void schedule() {
        SLF4JLogEmitter.randomLog();
    }
}
