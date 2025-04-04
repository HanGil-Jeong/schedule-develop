package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.SignUpResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

        return new SignUpResponseDto(findUserById.getId(), findUserById.getUsername(), findUserById.getAge(), findUserById.getEmail());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findUserById = userRepository.findByIdOrElseThrow(id);

        if (!findUserById.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findUserById.UpdatePassword(newPassword);
    }
}
