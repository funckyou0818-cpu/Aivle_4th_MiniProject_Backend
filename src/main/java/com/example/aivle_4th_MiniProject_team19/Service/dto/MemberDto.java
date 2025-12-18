package com.example.aivle_4th_MiniProject_team19.Service.dto;

import com.example.aivle_4th_MiniProject_team19.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private String username;
    private String password;

    // Entity -> Dto
    public static MemberDto from(Member member) {

        if (member == null) {
            return null;
        }

        return MemberDto.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .build();
    }
}
