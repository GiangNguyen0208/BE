package com.se_project.be.service;



import org.springframework.security.core.userdetails.User;

import java.util.List;
public interface UserService {
    User addUser(User user);

    User updateUser(User user);

}
