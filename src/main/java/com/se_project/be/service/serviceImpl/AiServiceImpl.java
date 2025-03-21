package com.se_project.be.service.serviceImpl;

import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl {
    private final WebClient webClient;

    public AiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
    }

    public String sendToAiModel(String question) {
        String apiKey = "your-api-key"; // Thay thế bằng API Key thật

        return webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(Map.of(
                        "model", "gpt-4",
                        "messages", List.of(Map.of("role", "user", "content", question))
                ))
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Lấy kết quả đồng bộ
    }
}
