package com.springbootfirst.web.repository;

import com.springbootfirst.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
