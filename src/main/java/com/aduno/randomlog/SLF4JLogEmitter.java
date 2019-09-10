package com.aduno.randomlog;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.UUID;

public class SLF4JLogEmitter implements LogEmitter {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private RandomLevelGenerator randomLog;

    public SLF4JLogEmitter() {
        this(new DefaultRandomLevelGenerator());
    }

    protected SLF4JLogEmitter(RandomLevelGenerator generator) {
        randomLog = generator;
    }

    @Override
    public void log(Level loglevel, String text) {
        switch (loglevel) {
            case TRACE:
                logger.trace(text);
                break;
            case DEBUG:
                logger.debug(text);
                break;
            case INFO:
                logger.info(text);
                break;
            case WARN:
                logger.warn(text);
                break;
            case ERROR:
                logger.error(text);
                break;
            default:
                logger.debug(text);
                break;
        }
    }

    @Timed
    @Override
    public void randomLog() {
        log(randomLog.get(), UUID.randomUUID().toString());
    }
}
