package com.example.lecture_registration.lecture.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import com.example.lecture_registration.user.domain.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional
class LectureEnrollmentJpaRepositoryTest {

    @Autowired
    private LectureEnrollmentJpaRepository lectureEnrollmentJpaRepository;

    @Test
    void findAllWithLectureDetailsByUser_로_사용자가_등록한_특강목록을_찾아올_수_있다() {
        User user = new User();
        user.setId(1L);
        user.setName("test");


        List<LectureEnrollmentResponse> responses =
            lectureEnrollmentJpaRepository.findAllWithLectureDetailsByUser(user);

        assertThat(responses).isNotEmpty();
    }
}