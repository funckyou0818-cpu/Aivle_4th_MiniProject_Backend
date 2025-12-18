package com.example.aivle_4th_MiniProject_team19.Service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupResponseDto {
    private Long userId;
    private String name;   // username
}
