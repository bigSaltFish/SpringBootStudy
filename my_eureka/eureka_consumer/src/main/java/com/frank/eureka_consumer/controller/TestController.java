package com.frank.eureka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/info")
    public String getInfo() {
        return this.restTemplate.getForEntity("http://SERVER-PROVIDER/info", String.class).getBody();
    }
    @RequestMapping("/info2")
    public String getInfo2() {
        return this.restTemplate.getForEntity("http://SERVER-PROVIDER/info", String.class).getBody();
    }
}
