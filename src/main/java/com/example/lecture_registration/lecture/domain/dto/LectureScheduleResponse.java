package com.example.lecture_registration.lecture.domain.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LectureScheduleResponse {

    private Long lectureId;
    private String lectureName;
    private String instructorName;
    private Long lectureScheduleId;
    private LocalDateTime scheduledAt;

}
