package com.example.lecture_registration.lecture.persistence;

import com.example.lecture_registration.lecture.domain.LectureEnrollment;
import com.example.lecture_registration.lecture.domain.dto.LectureEnrollmentResponse;
import com.example.lecture_registration.user.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureEnrollmentJpaRepository extends JpaRepository<LectureEnrollment, Long> {

    @Query("SELECT l.id, l.name, ls.id, ls.id, ls.scheduledAt, l.instructor.id, l.instructor.name "
        + "FROM LectureEnrollment le " +
        "JOIN le.lectureSchedule ls " +
        "JOIN ls.lecture l " +
        "WHERE le.user = :user")
    List<LectureEnrollmentResponse> findAllWithLectureDetailsByUser(User user);
}
