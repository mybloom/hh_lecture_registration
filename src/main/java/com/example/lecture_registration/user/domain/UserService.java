package com.example.lecture_registration.user.domain;

import com.example.lecture_registration.user.exception.UserErrorCode;
import com.example.lecture_registration.user.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User retrieveUserById(Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));
    }
}
