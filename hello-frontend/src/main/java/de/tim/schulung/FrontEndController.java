package de.tim.schulung;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontEndController {

    @Autowired
    private HelloRestClient helloRestClient;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(Model model) {
        String response = helloRestClient.sayHello();
        model .addAttribute("response", response );
        return "hello";
    }
}