package com.example.lecture_registration.lecture.domain;

import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import com.example.lecture_registration.user.domain.User;
import java.util.List;

public interface LectureEnrollmentRepository {

    List<LectureEnrollmentResponse> findAllWithLectureDetailsByUser(User user);
}
