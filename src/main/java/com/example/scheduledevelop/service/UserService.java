package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignUpResponseDto saveUserInfo(String username, Integer age, String email, String password) {

        User user = new User(username, age, email, password);

        User saveUserInfo = userRepository.save(user);

        return new SignUpResponseDto(saveUserInfo.getId(), saveUserInfo.getUsername(), saveUserInfo.getAge(), saveUserInfo.getEmail());
    }

    public SignUpResponseDto findUserInfoById(Long id) {

        User findUserById = userRepository.findByIdOrElseThrow(id);

        return new SignUpResponseDto(findUserById.getId(),findUserById.getUsername(), findUserById.getAge(), findUserById.getEmail());
    }
}
