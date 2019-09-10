package com.aduno.randomlog;

import io.micrometer.core.annotation.Timed;
import org.slf4j.event.Level;

public interface LogEmitter {
    void log(Level loglevel, String text);

    @Timed
    void randomLog();
}
