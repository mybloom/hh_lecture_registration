package com.example.lecture_registration.lecture.domain;

import static com.example.lecture_registration.lecture.exception.LectureErrorCode.*;

import com.example.lecture_registration.global.database.BaseTimeEntity;
import com.example.lecture_registration.lecture.exception.LectureException;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class LectureSchedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id") //TODO: insertable = false, updatable = false)
    private Lecture lecture;

    private LocalDateTime scheduledAt;

    public static LocalDateTime convertToLocalDateTime(LocalDate scheduleRequestDate) {
        validateScheduledAt(scheduleRequestDate);
        if (scheduleRequestDate.equals(LocalDate.now())) {
            return LocalDateTime.now();
        }

        return scheduleRequestDate.atStartOfDay();
    }

    public static void validateScheduledAt(LocalDate scheduleRequestDate) {
        if (scheduleRequestDate.isBefore(LocalDate.now())) {
            throw new LectureException(LECTURE_SCHEDULE_INVALID_PAST_DATE);
        }
    }

}

