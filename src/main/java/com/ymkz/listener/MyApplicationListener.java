package com.ymkz.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by song on 2020/10/28.
 */
@Component
public class MyApplicationListener implements ApplicationListener {
    private static Logger log = LoggerFactory.getLogger(MyApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationContextInitializedEvent) {
            log.info("ApplicationContextInitializedEvent....");
        } else if (event instanceof ApplicationEnvironmentPreparedEvent) {
            log.info("ApplicationEnvironmentPreparedEvent....");
        }
    }
}
