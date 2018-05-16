package com.aduno.randomlog;


import org.slf4j.event.Level;

import java.util.Random;

public class DefaultRandomLevelGenerator implements RandomLevelGenerator {

    public Level get() {
        int random = new Random().nextInt(Level.values().length);
        return Level.values()[random];
    }
}
