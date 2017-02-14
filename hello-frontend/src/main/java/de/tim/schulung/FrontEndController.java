package de.tim.schulung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontEndController {

    private static final Logger LOG = LoggerFactory.getLogger(FrontEndController.class);
    @Autowired
    private HelloRestClient helloRestClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(Model model) {
        LOG.info("WEBCONTROLLER");
        String response = helloRestClient.sayHello();
        model .addAttribute("response", response );
        return "hello";
    }
}