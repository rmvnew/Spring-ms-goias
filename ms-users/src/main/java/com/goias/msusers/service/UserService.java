package com.goias.msusers.service;

import com.goias.msusers.model.User;
import com.goias.msusers.resources.dto.request.UserRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserResponseDto save(UserRequestDto requestDto);

    Page<UserResponseDto> getAll(Pageable page);

}
