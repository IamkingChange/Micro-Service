package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GreetingService {
    //前面的greeting式註冊在Eureka的APP名(該service屬性宣告的spring.application.name, 或吃config server)
    private static final String URL = "http://greeting/Greeting";
    private RestTemplate rest;
    public GreetingService(RestTemplate rest) {
        this.rest = rest;
    }
    String getGreeting() {
        return rest.getForObject(URL, String.class);
    }
    String getGreeting(String locale) {
        return rest.postForObject(new StringBuffer().append(URL).append("/").append(locale).toString(),null, String.class);
    }

}
