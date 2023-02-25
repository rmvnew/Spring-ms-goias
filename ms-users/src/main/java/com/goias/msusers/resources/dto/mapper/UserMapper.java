package com.goias.msusers.resources.dto.mapper;

import com.goias.msusers.model.User;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toDto(User user);

//    Page<UserResponseDto> toPageDto(Page<User> users);

}
