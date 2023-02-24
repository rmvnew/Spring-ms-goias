package com.goias.msusers.resources.dto.mapper;

import com.goias.msusers.model.User;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toDto(User user);

}
