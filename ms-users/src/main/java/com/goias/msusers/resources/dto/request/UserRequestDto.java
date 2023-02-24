package com.goias.msusers.resources.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank
    private String userName;

    @Email
    @NotBlank
    private String userEmail;

    @NotBlank
    @Size(min = 5,max = 10)
    private String userPassword;

    @NotEmpty
    private Long profileId;

}
