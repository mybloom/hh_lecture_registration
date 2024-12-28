package com.example.lecture_registration.lecture.domain;

import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface LectureScheduleRepository {

    List<LectureScheduleResponse> findByScheduledAtAfterWithLecture(LocalDateTime param);
}
