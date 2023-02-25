package com.goias.msusers.service.impl;

import com.goias.msusers.model.User;
import com.goias.msusers.repository.ProfileRepository;
import com.goias.msusers.repository.UserRepository;
import com.goias.msusers.resources.dto.mapper.UserMapper;
import com.goias.msusers.resources.dto.request.UserRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import com.goias.msusers.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDto save(UserRequestDto requestDto) {

        var currentPass = BCrypt.hashpw(requestDto.getUserPassword(),BCrypt.gensalt(8));
        var profile = this.profileRepository.findById(requestDto.getProfileId()).get();

        User user = new User(
                requestDto.getUserName().trim().toUpperCase(),
                requestDto.getUserEmail(),
                currentPass,profile);

        var saved = this.userRepository.save(user);

        return userMapper.toDto(saved);
    }

    @Override
    public Page<UserResponseDto> getAll(Pageable page) {
        return this.userRepository.findAll(page).map(userMapper::toDto);

    }
}
