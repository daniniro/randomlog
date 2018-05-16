package com.aduno.randomlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LogScheduler {
    @Autowired
    private LogEmitter logEmitter;

    @Scheduled(cron = "${scheduling.job.cron}")
    public void schedule(){
        logEmitter.randomLog();
    }
}
