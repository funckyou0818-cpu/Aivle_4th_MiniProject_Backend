package com.example.aivle_4th_MiniProject_team19.Service;

import com.example.aivle_4th_MiniProject_team19.Service.dto.LoginResponseDto;
import com.example.aivle_4th_MiniProject_team19.Service.dto.MemberDto;
import com.example.aivle_4th_MiniProject_team19.Service.dto.SignupResponseDto;

public interface MemberService {
    SignupResponseDto createMember(MemberDto dto);
    MemberDto getMember(Long id);

    LoginResponseDto login(String username, String password);
}
