package com.example.lecture_registration.lecture.domain;

import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import com.example.lecture_registration.user.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LectureEnrollmentService {

    private final LectureEnrollmentRepository lectureEnrollmentRepository;

    public List<LectureEnrollmentResponse> retrieveEnrollmentByUser(User user) {
        List<LectureEnrollmentResponse> lectureEnrollmentResponses = lectureEnrollmentRepository.findAllWithLectureDetailsByUser(user);
        return lectureEnrollmentResponses;
    }
}
