package com.mq.active;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="testmq")
public class ActiveConfig {

    private String active;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
