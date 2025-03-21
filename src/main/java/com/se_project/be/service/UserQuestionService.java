package com.se_project.be.service;

import com.se_project.be.entity.UserQuestion;

import java.util.List;

public interface UserQuestionService {
    UserQuestion saveQuestion(String userId, String question);
    List<UserQuestion> getUserQuestions(String userId);
}
