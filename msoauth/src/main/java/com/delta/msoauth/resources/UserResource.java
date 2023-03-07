package com.delta.msoauth.resources;

import com.delta.msoauth.entities.User;
import com.delta.msoauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "oauth")
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/search")
    public ResponseEntity<User> findByUserEmail(@RequestParam String email){
       try{
           return ResponseEntity.ok(this.userService.findByUserEmail(email));
       }catch (Exception e){
           System.out.println(e.getMessage());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

}
