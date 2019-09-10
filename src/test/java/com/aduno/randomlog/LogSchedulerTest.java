package com.aduno.randomlog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class LogSchedulerTest {

    @Mock
    private LogEmitter emitter;
    private LogScheduler logScheduler;

    @Before
    public void setUp() {
        logScheduler = new LogScheduler(emitter);
    }

    @Test
    public void happyPath() {
        logScheduler.schedule();
        then(emitter).should().randomLog();
    }
}