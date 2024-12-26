package com.example.lecture_registration.lecture.domain;

import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureService {

    private final LectureScheduleRepository lectureScheduleRepository;

    public List<LectureScheduleResponse> retrieveAvailableLectures(LocalDate date) {
        LocalDateTime scheduledAt = LectureSchedule.convertToLocalDateTime(date);
        List<LectureScheduleResponse> lectureScheduleResponses
            = lectureScheduleRepository.findByScheduledAtAfterWithLecture(scheduledAt);
        return lectureScheduleResponses;
    }

}
