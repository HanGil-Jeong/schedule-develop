package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.SignUpRequestDto;
import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> saveUserInfo(
            @RequestBody SignUpRequestDto requestDto
    ) {

        SignUpResponseDto signUpResponseDto =
                userService.saveUserInfo(
                        requestDto.getUsername(),
                        requestDto.getAge(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignUpResponseDto> findUserInfoById(@PathVariable Long id) {

        SignUpResponseDto signUpResponseDto = userService.findUserInfoById(id);

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }

}
