package com.example.lecture_registration.lecture.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import com.example.lecture_registration.lecture.exception.LectureErrorCode;
import com.example.lecture_registration.lecture.exception.LectureException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LectureServiceTest {

    @Autowired
    private LectureScheduleRepository lectureScheduleRepository;

    @Autowired
    private LectureService lectureService;

    @Test
    void 성공케이스_특정_날짜의_특강신청가능_목록을_조회한다() {
        //given
        LocalDate requestDate = LocalDate.now();

        //when
        List<LectureScheduleResponse> lectureScheduleResponses
            = lectureService.retrieveAvailableLectures(requestDate);

        //then
        assertThat(lectureScheduleResponses).isNotEmpty();
    }

    @Test
    void 실패케이스_지난_날짜의_특강신청가능_목록을_조회한다() {
        //given
        LocalDate requestDate = LocalDate.now().minusDays(1);

        //then
        assertThatThrownBy(() -> lectureService.retrieveAvailableLectures(requestDate))
            .isInstanceOf(LectureException.class)
            .hasMessage(LectureErrorCode.LECTURE_SCHEDULE_INVALID_PAST_DATE.getMessage());
    }
}
