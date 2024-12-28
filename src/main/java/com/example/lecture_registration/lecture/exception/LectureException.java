package com.example.lecture_registration.lecture.exception;

import com.example.lecture_registration.global.error.BusinessException;

public class LectureException extends BusinessException {

    public LectureException(LectureErrorCode lectureErrorCode) {
        super(lectureErrorCode);
    }

}
