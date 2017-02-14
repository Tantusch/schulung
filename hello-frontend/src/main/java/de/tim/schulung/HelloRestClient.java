package de.tim.schulung;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Component
public class HelloRestClient {

    @Autowired
    RestTemplate template;

    @HystrixCommand(fallbackMethod = "defaultHello")
    public  String sayHello() {
        return template.getForObject("http://hello-web", String.class);
    }

    public String defaultHello() {
        return "Service is down";
    }

}
