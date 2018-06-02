package com.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "error")
    public String test(String name){
        return  restTemplate.getForObject("http://SERVICE-CLIENT/hi?name="+name
                ,String.class);
    }

    public String error(String name){
        return "sorry" + name;
    }
}
