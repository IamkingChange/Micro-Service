package org.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties()//若要加prefix="abc", 對應的properties應該要有abc.xxx
public class GreetingProperties {
    private String greeting;
    private Map<String,String> greetings;
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Map<String, String> getGreetings() {
        return greetings;
    }
    public void setGreetings(Map<String, String> greetings) {
        this.greetings = greetings;
    }


}
