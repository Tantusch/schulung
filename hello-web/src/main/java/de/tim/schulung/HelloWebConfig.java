package de.tim.schulung;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties(prefix = "helloservice.config")
public class HelloWebConfig {
    private String changeMe;
    public String getChangeMe() {
        return changeMe;
    }
    public void setChangeMe(String changeMe ) {
        this.changeMe = changeMe ;
    }
}
