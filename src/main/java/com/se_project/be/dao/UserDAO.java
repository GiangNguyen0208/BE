package com.se_project.be.dao;



import com.se_project.be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByEmailId(String email);

    User findByEmailIdAndStatus(String email, String status);

    User findByRoleAndStatusIn(String role, List<String> status);

    List<User> findByRole(String role);

    User findByEmailIdAndRoleAndStatus(String emailId, String role, String status);

    List<User> findByRoleAndStatus(String role, String status);


}
