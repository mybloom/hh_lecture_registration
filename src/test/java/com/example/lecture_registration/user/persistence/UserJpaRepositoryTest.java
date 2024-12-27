package com.example.lecture_registration.user.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.lecture_registration.user.domain.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class UserJpaRepositoryTest {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Transactional
    @Test
    void findById_로_유저_데이터를_찾아올_수_있다() {
        // given

        // when
        Optional<User> result = userJpaRepository.findById(10L);

        // then
        assertThat(result.isPresent()).isTrue();
    }
}