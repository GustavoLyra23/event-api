package com.lyra.event.dto.usercredential;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCredentialRequestDto(
        @NotBlank(message = "email cant' be blank") @Email(message = "invalid email format") String email,
        @NotBlank @Size(min = 1, max = 20, message = "password must have 1 or 20 characters") String password,
        @NotBlank(message = "username cant'be blank") String username) {
}
