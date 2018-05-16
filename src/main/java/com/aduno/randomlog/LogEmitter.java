package com.aduno.randomlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.UUID;

public class LogEmitter {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private RandomLevelGenerator randomLog;

    public LogEmitter (){
        this(new DefaultRandomLevelGenerator());
    }

    protected LogEmitter(RandomLevelGenerator generator){
        randomLog=generator;
    }

    public void log(Level loglevel, String text) {
        switch (loglevel){
            case TRACE: logger.trace(text);break;
            case DEBUG: logger.debug(text);break;
            case INFO: logger.info(text);break;
            case WARN: logger.warn(text);break;
            case ERROR: logger.error(text);break;
            default: logger.debug(text);break;
        }
    }

    public void randomLog() {
        log(randomLog.get(),UUID.randomUUID().toString());
    }
}
