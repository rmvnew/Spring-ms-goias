package com.goias.msusers.resources.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequestDto {
    @NotBlank
    private String userName;

    @Email
    @NotBlank
    private String userEmail;

    @NotEmpty
    private Long profileId;

}
