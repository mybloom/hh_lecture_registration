package com.example.lecture_registration.lecture.exception;

import com.example.lecture_registration.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum LectureErrorCode implements ErrorCode {
    LECTURE_SCHEDULE_INVALID_PAST_DATE(HttpStatus.BAD_REQUEST, "요청한 날짜는 오늘보다 이전일 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
