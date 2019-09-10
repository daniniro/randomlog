package com.aduno.randomlog;

import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomLogApi {
    private LogEmitter logEmitter;

    @Autowired
    public RandomLogApi(LogEmitter logEmitter) {
        this.logEmitter = logEmitter;
    }


    @PostMapping(path = "/logs", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createLog(@RequestParam(required = false) String message) {
        if (StringUtils.isEmpty(message)) {
            logEmitter.randomLog();
        } else {
            logEmitter.log(Level.INFO, message);
        }
    }
}
