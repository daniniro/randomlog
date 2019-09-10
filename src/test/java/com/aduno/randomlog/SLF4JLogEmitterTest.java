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
public class SLF4JLogEmitterTest {
    @Mock
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Mock
    private RandomLevelGenerator randomLevel;
    private SLF4JLogEmitter SLF4JLogEmitter;


    @Before
    public void setUp() {
        SLF4JLogEmitter = new SLF4JLogEmitter(randomLevel);
        SLF4JLogEmitter.logger = logger;
    }

    @Test
    public void emitLog() {
        String text = UUID.randomUUID().toString();
        SLF4JLogEmitter.log(Level.WARN, text);
        then(logger).should().warn(text);
    }

    @Test
    public void randomString() {
        given(randomLevel.get()).willReturn(Level.DEBUG);
        SLF4JLogEmitter.randomLog();
        then(logger).should().debug(Mockito.anyString());
    }

}
