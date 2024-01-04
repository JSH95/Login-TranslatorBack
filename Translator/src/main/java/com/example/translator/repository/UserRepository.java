package com.example.translator.repository;

import com.example.translator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    public User findByIdAndPassword(String id, String password);
}
