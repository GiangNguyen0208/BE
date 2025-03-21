package com.se_project.be.controller;

import com.se_project.be.dto.request.PrompRequest;
import com.se_project.be.service.ChatGPTService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/chat")
public class ChatGPTController {
    private final ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }
    @PostMapping
    public String chatRequestBody(@RequestBody PrompRequest prompRequest){
        return chatGPTService.getChatResponse(prompRequest);
    }

}
