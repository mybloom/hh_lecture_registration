package com.example.lecture_registration.user.exception;

import com.example.lecture_registration.global.error.BusinessException;

public class UserException extends BusinessException {

    public UserException(UserErrorCode errorCode) {
        super(errorCode);
    }
}
