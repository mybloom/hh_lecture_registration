package com.example.lecture_registration.lecture.persistence;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

//실제 데이터베이스를 사용하지 않고 @DataJpaTest를 이용한 통합 테스트 방식으로 테스트를 작성
@DataJpaTest
@Transactional //TODO: 이것의 의미 찾아보기. 넣는지 빼는지
class LectureScheduleJpaRepositoryTest {

    @Autowired
    private LectureScheduleJpaRepository lectureScheduleJpaRepository;

    @Test
    public void findByScheduledAtAfterWithLecture_로_현재_이후_시작하는_특강목록을_찾아올_수_있다() {
        LocalDateTime param = LocalDateTime.of(2024, 12, 30, 0, 0, 0);

        //when
        List<LectureScheduleResponse> responses = lectureScheduleJpaRepository.findByScheduledAtAfterWithLecture(param);

        //then
        assertThat(responses).isNotEmpty();
        LectureScheduleResponse firstResponse = responses.get(0);
        assertThat(firstResponse.getLectureName()).isNotNull();
        assertThat(firstResponse.getScheduledAt()).isNotNull();
    }

    @Test
    public void findByScheduledAtAfterWithLecture_로_특강이_없는날은_특강목록의_사이즈가_0이다() {
        LocalDateTime param = LocalDateTime.of(2025, 1, 1, 0, 0, 0);

        //when
        List<LectureScheduleResponse> responses = lectureScheduleJpaRepository.findByScheduledAtAfterWithLecture(param);

        //then
        assertThat(responses).isEmpty();
        assertThat(responses).isNotNull();
    }

}