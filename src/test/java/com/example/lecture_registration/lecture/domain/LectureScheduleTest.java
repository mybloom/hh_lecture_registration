package com.example.lecture_registration.lecture.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.example.lecture_registration.lecture.exception.LectureErrorCode;
import com.example.lecture_registration.lecture.exception.LectureException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("특강신청 가능 목록 조회")
class LectureScheduleTest {

    LectureSchedule lectureSchedule = new LectureSchedule();

    @Test
    void 요청한_날짜가_오늘보다_이전일_경우_실패() {
        // given
        LocalDate scheduleRequestDate = LocalDate.now().minusDays(1);

        // when & then
        assertThatThrownBy(
            () -> lectureSchedule.validateScheduledAt(scheduleRequestDate))
            .isInstanceOf(LectureException.class)
            .hasMessage(LectureErrorCode.LECTURE_SCHEDULE_INVALID_PAST_DATE.getMessage());
    }

    @Test
    void 요청한_날짜가_오늘_이후일_경우_성공() {
        // given
        LocalDate scheduleRequestDate = LocalDate.now().plusDays(1);

        // when & then
        assertDoesNotThrow(() -> lectureSchedule.validateScheduledAt(scheduleRequestDate));
    }

    @Test
    void 요청한_날짜가_오늘일_경우_성공() {
        // given
        LocalDate scheduleRequestDate = LocalDate.now();

        // when & then
        assertDoesNotThrow(() -> lectureSchedule.validateScheduledAt(scheduleRequestDate));
    }

    @Test
    void 요청한_날짜가_오늘일_경우_현재일시의_LocalDateTime_리턴() {
        // given
        LocalDate scheduleRequestDate = LocalDate.now();
        // 현재 시간을 고정하여 저장
        LocalDateTime expectedDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);

        // when
        LocalDateTime actualDateTime = lectureSchedule.convertToLocalDateTime(scheduleRequestDate);

        // then
        assertDoesNotThrow(() -> lectureSchedule.validateScheduledAt(scheduleRequestDate));
        // ChronoUnit.MINUTES: 정밀도가 "시간 단위"로 제한
        assertThat(actualDateTime.truncatedTo(ChronoUnit.HOURS)).isEqualTo(expectedDateTime);
    }

    @Test
    void 요청한_날짜가_내일일_경우_내일00시_리턴() {
        // given
        LocalDate scheduleRequestDate = LocalDate.now().plusDays(1);

        // when
        LocalDateTime actualDateTime = lectureSchedule.convertToLocalDateTime(scheduleRequestDate);

        // then
        assertDoesNotThrow(() -> lectureSchedule.validateScheduledAt(scheduleRequestDate));
        assertThat(actualDateTime.truncatedTo(ChronoUnit.HOURS))
            .isEqualTo(LocalDate.now().plusDays(1).atStartOfDay());
    }

}