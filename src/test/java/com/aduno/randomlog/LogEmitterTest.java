package com.aduno.randomlog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class LogEmitterTest {
    @Mock
    private Logger logger = LoggerFactory.getLogger(this.getClass());
@Mock
    private RandomLevelGenerator randomLevel;
    private LogEmitter logEmitter;


    @Before
    public void setUp() {
        logEmitter = new LogEmitter(randomLevel);
        logEmitter.logger = logger;
    }
    @Test
    public void emitLog() {
        String text = UUID.randomUUID().toString();
        logEmitter.log(Level.WARN, text);
        then(logger).should().warn(text);
    }

    @Test
    public void randomString(){
        given(randomLevel.get()).willReturn(Level.DEBUG);
        logEmitter.randomLog();
        then(logger).should().debug(Mockito.anyString());
    }

}
