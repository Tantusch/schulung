package de.tim.schulung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloWebRestController {

    @Autowired
    HelloWebConfig helloWebConfig;

    @Autowired
    Environment env;

    @Value("${message:Hello default}")
    private String message;

    private static final Logger LOG = LoggerFactory.getLogger(HelloWebRestController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        LOG.info("RESTCONTROLLER");
        return message + " " + env.getProperty("local.server.port");
    }

    @RequestMapping(value = "/changeMe", method = RequestMethod.GET)
    public String sayChangeMe() {
        return helloWebConfig.getChangeMe();
    }
}