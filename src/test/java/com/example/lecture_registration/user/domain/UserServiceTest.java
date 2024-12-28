package com.example.lecture_registration.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.example.lecture_registration.user.exception.UserErrorCode;
import com.example.lecture_registration.user.exception.UserException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void 존재하지_않는_userId_일_경우_실패() {
        long userId = 0L;
        assertThatThrownBy(() -> userService.retrieveUserById(userId))
            .isInstanceOf(UserException.class)
            .hasMessage(UserErrorCode.USER_NOT_FOUND.getMessage());
    }

    @Test
    void 성공케이스_존재하는_userId_일_경우_사용자정보_전달받는다() {
        // given
        long userId = 1L;

        // when
        User user = userService.retrieveUserById(userId);

        // then
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
    }

}