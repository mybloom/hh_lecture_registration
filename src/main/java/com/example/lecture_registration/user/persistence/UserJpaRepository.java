package com.example.lecture_registration.user.persistence;

import com.example.lecture_registration.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);
}
