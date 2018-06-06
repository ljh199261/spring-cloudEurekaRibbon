package com.controller;


import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @RequestMapping(value = "/hi")
    public String test(@RequestParam String name){
        return testService.test(name);
    }
}
