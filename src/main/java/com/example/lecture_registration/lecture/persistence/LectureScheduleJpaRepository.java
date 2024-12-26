package com.example.lecture_registration.lecture.persistence;


import com.example.lecture_registration.lecture.domain.LectureSchedule;
import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureScheduleJpaRepository extends JpaRepository<LectureSchedule, Long> {

    @Query("SELECT new com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse"
        + "(l.id, l.name, l.instructor.name, ls.id, ls.scheduledAt)"
        + " FROM LectureSchedule ls "
        + "JOIN ls.lecture l "
        + "WHERE ls.scheduledAt > :param")
    List<LectureScheduleResponse> findByScheduledAtAfterWithLecture(LocalDateTime param);
}
