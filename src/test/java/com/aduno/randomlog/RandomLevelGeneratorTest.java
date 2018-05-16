package com.aduno.randomlog;

import org.junit.Test;
import org.slf4j.event.Level;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;

public class RandomLevelGeneratorTest {
    @Test
    public void random(){
        RandomLevelGenerator randomLevelGenerator = new DefaultRandomLevelGenerator();
        assertThat(randomLevelGenerator.get(),isOneOf(Level.values()));
    }
}
