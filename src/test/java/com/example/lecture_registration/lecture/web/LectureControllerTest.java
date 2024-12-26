package com.example.lecture_registration.lecture.web;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.lecture_registration.lecture.domain.LectureService;
import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import com.example.lecture_registration.lecture.exception.LectureErrorCode;
import com.example.lecture_registration.lecture.exception.LectureException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(LectureController.class)
@ExtendWith(SpringExtension.class)
class LectureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LectureService lectureService;

    @Test
    void 특강신청가능목록_날짜_파라미터가_null_이면_실패() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/lectures/schedule?date="))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void 특강신청가능목록_날짜_파라미터가_잘못된형식_이면_실패() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/lectures/schedule?date=2024-01-01T00:00:00"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void 특강신청가능목록_요청날짜가_어제_이면_실패() throws Exception {
        //given
        LocalDate pastDate = LocalDate.of(2024, 12, 25);

        when(lectureService.retrieveAvailableLectures(pastDate))
            .thenThrow(new LectureException(LectureErrorCode.LECTURE_SCHEDULE_INVALID_PAST_DATE));

        //when: MockMvc performs a GET request with a past date
        mockMvc.perform(MockMvcRequestBuilders.get("/lectures/schedule")
                .param("date", pastDate.toString())
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value(LectureErrorCode.LECTURE_SCHEDULE_INVALID_PAST_DATE.getMessage()));

        // Verify service method call
        verify(lectureService, times(1)).retrieveAvailableLectures(pastDate);
    }

    @Test
    void 특강신청가능목록_성공() throws Exception {
        //given
        LocalDate requestDate = LocalDate.of(2024, 12, 30);
        List<LectureScheduleResponse> mockResponse = List.of(
            new LectureScheduleResponse(1L, "Lecture 1", "instructor 1", 1L, LocalDateTime.of(2024, 12, 30, 10, 0)),
            new LectureScheduleResponse(2L, "Lecture 2", "instructor 2", 2L, LocalDateTime.of(2024, 12, 30, 12, 0))
        );
        when(lectureService.retrieveAvailableLectures(requestDate))
            .thenReturn(mockResponse);

        //when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/lectures/schedule?date=2024-12-30")
            .param("date", requestDate.toString())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].lectureName").value("Lecture 1"));
    }

}