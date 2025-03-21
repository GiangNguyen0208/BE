package com.se_project.be.controller;

import com.se_project.be.dto.request.UserInputRequestDTO;
import com.se_project.be.service.AiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final AiService aiService;

    public QuestionController(AiService aiService) {
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
}

