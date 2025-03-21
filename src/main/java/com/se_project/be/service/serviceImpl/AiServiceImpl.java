package com.se_project.be.service.serviceImpl;

import com.se_project.be.service.AiService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AiServiceImpl implements AiService {
    private final WebClient webClient;

    public AiServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
    }

    @Override
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
