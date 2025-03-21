package com.se_project.be.dao;



import com.se_project.be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
