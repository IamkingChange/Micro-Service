package org.example;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
@RequestMapping("/Web")
public class WebController {
    private GreetingService greetingService;
    private NameService nameService;

    public WebController(GreetingService greetingService, NameService nameService) {
        this.greetingService = greetingService;
        this.nameService = nameService;
    }

    @RequestMapping("/")
    public String getGreetingAndName(HttpServletRequest request) {
        String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).getLanguage();
        String result = new StringBuffer().append(greetingService.getGreeting(locale)).append(" - ").append(nameService.getName()).toString();
        return result;
    }
}
