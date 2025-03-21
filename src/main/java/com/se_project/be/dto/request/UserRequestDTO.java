package com.se_project.be.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserRequestDTO {
    String username;
    String email;
    String password;
}
