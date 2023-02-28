package com.goias.msusers.resources.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecoverPassRequestDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String code;

    @NotBlank
    @Size(min = 5, max = 10)
    private String pass;

}
