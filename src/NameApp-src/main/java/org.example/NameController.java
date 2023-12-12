package org.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("Name/")
public class NameController {
    private NameProperties nameProperties;
    private static final Logger LOG = Logger.getLogger(NameProperties.class.getName());
    public NameController(NameProperties nameProperties) {
        this.nameProperties =  nameProperties;
    }

    @RequestMapping("/")
    public String getName() {
        LOG.info(nameProperties.getName());
        return nameProperties.getName();
    }
}
