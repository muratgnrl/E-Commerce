package com.example.authservice.repository;

import com.example.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(long userId);

    User findUserByMailAndPassword(String mail, String number);

    void deleteByUserId(long userId);

}
