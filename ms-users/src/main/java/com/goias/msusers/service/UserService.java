package com.goias.msusers.service;

import com.goias.msusers.resources.dto.request.UserRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;

public interface UserService {

    UserResponseDto save(UserRequestDto requestDto);

}
