package com.example.lecture_registration.lecture.domain.dto;


import com.example.lecture_registration.lecture.domain.LectureEnrollment;
import lombok.Getter;

@Getter
public class LectureEnrollmentResponse {

    private Long lectureId;
    private String lectureName;
    private Long lectureScheduleId;
    private String lectureScheduledAt;
    private String instructorId;
    private String instructorName;

    public static LectureEnrollmentResponse from(LectureEnrollment lectureEnrollment) {
        return null;
    }
}
