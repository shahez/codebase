package com.workllama.microservices.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckAPI {
    @RequestMapping("/ping")
    public String ping() {
        return "ping";
    }

}
