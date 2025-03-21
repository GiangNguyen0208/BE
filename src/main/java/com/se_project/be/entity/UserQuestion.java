package com.se_project.be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Tạo khóa ngoại user_id trong bảng user_question
    private User user;

    private String question;
    private String formattedQuestion;
    private String aiResponse;
    private LocalDateTime createdAt;
}
