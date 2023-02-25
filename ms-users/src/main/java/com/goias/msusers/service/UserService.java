package com.goias.msusers.service;

import com.goias.msusers.resources.dto.request.UserCreateRequestDto;
import com.goias.msusers.resources.dto.request.UserUpdateRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDto save(UserCreateRequestDto requestDto);

    Page<UserResponseDto> getAll(Pageable page);

    UserResponseDto findById(Long id);

    UserResponseDto updateUser(UserUpdateRequestDto requestDto, Long id);



}
