package com.goias.msusers.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserResources {

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello World!";
    }

}
