package com.example.lecture_registration.lecture.web;


import com.example.lecture_registration.lecture.domain.LectureEnrollmentFacade;
import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LectureEnrollmentController {

    private final LectureEnrollmentFacade lectureEnrollmentFacade;

    @GetMapping("/lectures/enrollment")
    public List<LectureEnrollmentResponse> retrieveEnrollmentByUser(@RequestParam(required = true) Long userId) {
        return lectureEnrollmentFacade.retrieveEnrollmentByUser(userId);
    }
}
