package com.example.lecture_registration.lecture.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LectureServiceMockTest {

    @Mock
    private LectureScheduleRepository lectureScheduleRepository;

    @InjectMocks
    private LectureService lectureService;

    @Test
    void 성공케이스_특정_날짜의_특강신청가능_목록을_조회한다() {
        //given
        LocalDate requestDate = LocalDate.now();

        List<LectureScheduleResponse> mockResponses = Arrays.asList(
            new LectureScheduleResponse(1L, "Lecture 1", "instructor 1", 5L, LocalDateTime.now()),
            new LectureScheduleResponse(2L, "Lecture 2", "instructor 2", 6L, LocalDateTime.now().plusHours(1))
        );
        // any(LocalDateTime.class) 사용 : LocalDateTime 값에 대해 세밀한 비교를 피하고, 어떤 LocalDateTime 값이든 일치하도록 설정
        when(lectureScheduleRepository.findByScheduledAtAfterWithLecture(any(LocalDateTime.class)))
            .thenReturn(mockResponses);

        //when
        List<LectureScheduleResponse> lectureScheduleResponses
            = lectureService.retrieveAvailableLectures(requestDate);

        //then
        assertThat(lectureScheduleResponses).isNotEmpty();
        assertThat(lectureScheduleResponses).hasSize(2);
        assertThat(lectureScheduleResponses.get(0).getInstructorName()).isEqualTo("instructor 1");
    }

}
