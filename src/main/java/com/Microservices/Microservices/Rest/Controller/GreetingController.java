package com.Microservices.Microservices.Rest.Controller;


import com.Microservices.Microservices.Domain.Greeting;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

public Greeting greeting (@RequestParam (value = "name", defaultValue = "world") String name) {
    return new Greeting( counter.incrementAndGet(), String.format(template, name));
}




}
