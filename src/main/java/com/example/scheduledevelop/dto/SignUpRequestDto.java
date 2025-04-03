package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username;

    private final Integer age;

    private final String email;

    private final String password;

    public SignUpRequestDto(String username, Integer age, String email, String password) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.password = password;
    }
}
