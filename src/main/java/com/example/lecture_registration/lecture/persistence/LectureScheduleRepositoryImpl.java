package com.example.lecture_registration.lecture.persistence;

import com.example.lecture_registration.lecture.domain.LectureScheduleRepository;
import com.example.lecture_registration.lecture.domain.dto.LectureScheduleResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LectureScheduleRepositoryImpl implements LectureScheduleRepository {

    //JpaRepository를 주입받아 갖고 있다.
    private final LectureScheduleJpaRepository lectureScheduleJpaRepository;

    @Override
    public List<LectureScheduleResponse> findByScheduledAtAfterWithLecture(LocalDateTime param) {
        return lectureScheduleJpaRepository.findByScheduledAtAfterWithLecture(param);
    }

}
