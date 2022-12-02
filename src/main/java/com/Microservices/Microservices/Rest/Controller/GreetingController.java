package com.Microservices.Microservices.Rest.Controller;


import com.Microservices.Microservices.Config.Configuration;
import com.Microservices.Microservices.Domain.Entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private Configuration configuration;

    // pegar o name que passar ou world como default

    @RequestMapping("/greeting")
public Greeting greeting (@RequestParam (value = "name", defaultValue = "") String name) {

        if (name.isEmpty()){
            name = configuration.getDefaultvalue();
        }
    return new Greeting( counter.incrementAndGet(), String.format(template, configuration.getGreeting(),name));
}




}
