package com.example.lecture_registration.user.domain;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long userId);
}
