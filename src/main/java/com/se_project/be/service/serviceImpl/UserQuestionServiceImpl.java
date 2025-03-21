package com.se_project.be.service.serviceImpl;

import com.se_project.be.dao.UserDAO;
import com.se_project.be.entity.UserQuestion;
import org.springframework.transaction.annotation.Transactional;

public class UserQuestionServiceImpl {
    private final UserDAO userDAO;
    private final AiService aiService;

    public UserQuestionService(userDAO userQuestionRepository, AiService aiService) {
        this.userDAO = userQuestionRepository;
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

        return userQuestionRepository.save(userQuestion);
    }

    public List<UserQuestion> getUserQuestions(String userId) {
        return userQuestionRepository.findByUserId(userId);
    }
}
