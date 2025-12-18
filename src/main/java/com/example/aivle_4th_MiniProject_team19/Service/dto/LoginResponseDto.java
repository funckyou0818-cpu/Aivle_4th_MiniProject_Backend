package com.example.aivle_4th_MiniProject_team19.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private String userId;       // "UUID" 대신 지금은 member.id.toString()
    private String username;
    private String accessToken;
    private String refreshToken;
}
