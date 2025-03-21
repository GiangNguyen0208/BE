package com.se_project.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_questions")
@Data
public class UserQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId; // Lưu ID người dùng (có thể thay bằng khóa ngoại nếu có User Entity)

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question; // Câu hỏi gốc do user nhập

    @Column(columnDefinition = "TEXT")
    private String formattedQuestion; // Câu hỏi đã được định dạng lại

    @Column(columnDefinition = "TEXT")
    private String aiResponse; // Phản hồi từ AI

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}

