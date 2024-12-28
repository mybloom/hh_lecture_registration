package com.example.lecture_registration.global.error;


import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus code, String message) {

}
