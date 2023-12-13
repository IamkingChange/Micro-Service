package org.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
@Service
public class NameService {
    private NameFeignClient nameFeignClient;
    public NameService(NameFeignClient nameFeignClient) {
        this.nameFeignClient = nameFeignClient;
    }
    String getName() {
        return nameFeignClient.getName();
    }
    @FeignClient("name")//"name"是對應到Eureka上的APP name, 或是你也可放對外的URL
    static interface NameFeignClient {
        @RequestMapping("/")
        public String getName();
    }
}
