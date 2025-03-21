package com.se_project.be.service.serviceImpl;


import com.se_project.be.dao.UserDAO;
import com.se_project.be.entity.User;
import com.se_project.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserByEmailAndStatus(String emailId, String status) {
        return userDao.findByEmailIdAndStatus(emailId, status);
    }
    @Override
    public User getUserByEmailid(String emailId) {
        return userDao.findByEmailId(emailId);
    }

    @Override
    public List<User> getUserByRole(String role) {
        return userDao.findByRole(role);
    }

    @Override
    public User getUserById(int userId) {

        Optional<User> optionalUser = this.userDao.findById(userId);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }

    }

    @Override
    public User getUserByEmailIdAndRoleAndStatus(String emailId, String role, String status) {
        return this.userDao.findByEmailIdAndRoleAndStatus(emailId, role, status);
    }

    @Override
    public List<User> updateAllUser(List<User> users) {
        return this.userDao.saveAll(users);
    }

    @Override
    public List<User> getUserByRoleAndStatus(String role, String status) {
        return this.userDao.findByRoleAndStatus(role, status);
    }

    @Override
    public int activeUser(String email) {
        return userDao.activeUser(email);
    }
}

