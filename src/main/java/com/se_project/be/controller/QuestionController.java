package com.se_project.be.controller;

import com.se_project.be.dto.request.UserInputRequestDTO;
import com.se_project.be.dto.request.UserQuestionRequestDTO;
import com.se_project.be.entity.UserQuestion;
import com.se_project.be.service.AiService;
import com.se_project.be.service.UserQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private UserQuestionService userQuestionService;

    @Autowired
    private AiService aiService;

    public QuestionController(UserQuestionService userQuestionService, AiService aiService) {
        this.userQuestionService = userQuestionService;
        this.aiService = aiService;
    }

    @PostMapping("/format")
    public ResponseEntity<String> formatAndSendQuestion(@RequestBody UserInputRequestDTO request) {
        String formattedQuestion = formatQuestion(request.getUserInput());
        String aiResponse = aiService.sendToAiModel(formattedQuestion);
        return ResponseEntity.ok(aiResponse);
    }
    private String formatQuestion(String userInput) {
        // Định dạng lại câu hỏi theo mẫu mong muốn
        return "Câu hỏi được định dạng: " + userInput;
    }
    @PostMapping("/ask")
    public ResponseEntity<UserQuestion> askQuestion(@RequestBody UserQuestionRequestDTO request) {
        UserQuestion userQuestion = userQuestionService.saveFormattedQuestion(request);
        return ResponseEntity.ok(userQuestion);
    }

    @GetMapping("/history")
    public ResponseEntity<List<UserQuestion>> getUserQuestions(@RequestParam String userId) {
        List<UserQuestion> questions = userQuestionService.getUserQuestions(userId);
        return ResponseEntity.ok(questions);
    }
}

