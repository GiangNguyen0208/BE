package com.se_project.be.dto.response;

import org.aspectj.bridge.Message;

import java.util.List;

public record ChatGPTResponse(List<Choice> choices) {
    public static record Choice(Message message){
        public static record Message(String role, String content){}
    }
}
