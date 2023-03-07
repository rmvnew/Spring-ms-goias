package com.delta.msoauth.feignclient;

import com.delta.msoauth.entities.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "msusers", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/email")
    @Headers("Accept: application/json")
    ResponseEntity<User> findByUserEmail(@RequestParam String email);

}
