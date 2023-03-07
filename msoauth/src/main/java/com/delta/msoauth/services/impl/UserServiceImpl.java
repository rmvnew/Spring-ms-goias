package com.delta.msoauth.services.impl;

import com.delta.msoauth.entities.User;
import com.delta.msoauth.feignclient.UserFeignClient;
import com.delta.msoauth.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public User findByUserEmail(String email) {
        var user = userFeignClient.findByUserEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: "+email);
            throw new NoSuchElementException("Email not found");
        }
        logger.info("Email found: "+email);
        return user;
    }
}
