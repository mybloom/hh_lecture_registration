package com.example.lecture_registration.lecture.domain;

import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import com.example.lecture_registration.user.domain.User;
import com.example.lecture_registration.user.domain.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LectureEnrollmentFacade {

    private final LectureEnrollmentService lectureEnrollmentService;
    private final UserService userService;


    public List<LectureEnrollmentResponse> retrieveEnrollmentByUser(Long userId) {
        User user = userService.retrieveUserById(userId);
        List<LectureEnrollmentResponse> lectureEnrollmentResponses
            = lectureEnrollmentService.retrieveEnrollmentByUser(user);
        return lectureEnrollmentResponses;
    }

}
