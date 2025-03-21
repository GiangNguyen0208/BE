package com.se_project.be.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserQuestionRequestDTO {
    String yourJob;
    String levelNow;
    String target;
    String moreInfo;
}
