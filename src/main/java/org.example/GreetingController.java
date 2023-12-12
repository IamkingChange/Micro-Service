package org.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/Greeting")
public class GreetingController {
    private GreetingProperties greetingProperties;
    private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());
    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties =  greetingProperties;
    }

    @PostMapping("/{language}")
    public String getGreetingByLan(@PathVariable String language) {
        LOG.info("language: " + language + " -- " + greetingProperties.getGreetings().get(language.toUpperCase()));
        return "language: " + language + " -- " + greetingProperties.getGreetings().getOrDefault(language.toUpperCase(),"");
    }
    @PostMapping("/")
    public String getGreeting() {
        LOG.info(greetingProperties.getGreeting());
        return greetingProperties.getGreeting();
    }
}
