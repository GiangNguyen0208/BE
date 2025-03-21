package com.se_project.be.service.serviceImpl;

import com.se_project.be.dao.UserDAO;
import com.se_project.be.dao.UserQuestionDAO;
import com.se_project.be.entity.UserQuestion;
import com.se_project.be.service.AiService;
import com.se_project.be.service.UserQuestionService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class UserQuestionServiceImpl implements UserQuestionService {
    private final UserQuestionDAO userQuestionDAO;
    private final AiService aiService;

    public UserQuestionServiceImpl(UserQuestionDAO userQuestionRepository, AiService aiService) {
        this.userQuestionDAO = userQuestionRepository;
        this.aiService = aiService;
    }

    @Transactional
    public UserQuestion saveQuestion(String userId, String question) {
        // Định dạng câu hỏi
        String formattedQuestion = "Câu hỏi được định dạng: " + question;

        // Gửi đến AI
        String aiResponse = aiService.sendToAiModel(formattedQuestion);

        // Lưu vào database
        UserQuestion userQuestion = new UserQuestion();
        userQuestion.setUserId(userId);
        userQuestion.setQuestion(question);
        userQuestion.setFormattedQuestion(formattedQuestion);
        userQuestion.setAiResponse(aiResponse);
        userQuestion.setCreatedAt(LocalDateTime.now());

        return userQuestionDAO.save(userQuestion);
    }

    public List<UserQuestion> getUserQuestions(String userId) {
        return userQuestionDAO.findByUserId(userId);
    }
}
