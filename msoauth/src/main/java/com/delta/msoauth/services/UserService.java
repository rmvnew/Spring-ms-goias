package com.delta.msoauth.services;

import com.delta.msoauth.entities.User;

public interface UserService {

    User findByUserEmail(String email);

}
