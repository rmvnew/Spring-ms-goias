package com.goias.msusers.resources.dto.response;

import com.goias.msusers.model.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;

    private String userName;

    private String userEmail;

    private boolean isActive;

    private Profile profile;
}
