package com.goias.msusers.schedule;

import com.goias.msusers.enums.ErrorCode;
import com.goias.msusers.exceptions.CustomException;
import com.goias.msusers.repository.UserRepository;

import java.util.TimerTask;


public class updateCode extends TimerTask {

    private String email;

    private UserRepository userRepository;

    public updateCode(
            String email,
            UserRepository userRepository) {
        this.email = email;

        this.userRepository = userRepository;

    }

    @Override
    public void run() {
        var user = this.userRepository.findByUserEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        user.setRecoverCode("");

        userRepository.save(user);
    }
}
