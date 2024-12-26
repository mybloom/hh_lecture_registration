package com.example.lecture_registration.lecture.web;


import com.example.lecture_registration.lecture.domain.LectureService;
import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/lectures/schedule")
    public List<LectureScheduleResponse> findLectureSchedule(
        @RequestParam(required = true) LocalDate date) {
        return lectureService.retrieveAvailableLectures(date);
    }
}
