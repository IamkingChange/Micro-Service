package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }

    static class MyConfig {
        @Bean
        @LoadBalanced//加這個後, URL就可以用http://greeting/xxx , 走Eureka
        RestTemplate rest() {
            return  new RestTemplateBuilder().build();
        }
    }
}
