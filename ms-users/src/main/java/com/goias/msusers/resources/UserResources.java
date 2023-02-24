package com.goias.msusers.resources;

import com.goias.msusers.resources.dto.request.UserRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import com.goias.msusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user){
        return ResponseEntity.ok(this.userService.save(user));
    }

}
