package com.example.lecture_registration.lecture.persistence;

import com.example.lecture_registration.lecture.domain.LectureEnrollmentRepository;
import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import com.example.lecture_registration.user.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LectureEnrollmentRepositoryImpl implements LectureEnrollmentRepository {

    private final LectureEnrollmentJpaRepository lectureEnrollmentJpaRepository;

    @Override
    public List<LectureEnrollmentResponse> findAllWithLectureDetailsByUser(User user) {
        return lectureEnrollmentJpaRepository.findAllWithLectureDetailsByUser(user);
    }
}
