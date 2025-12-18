package com.example.aivle_4th_MiniProject_team19.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 간단히 고정 시크릿키 사용 (개발용)
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 만료시간 (ms)
    private final long ACCESS_TOKEN_EXPIRATION = 1000L * 60 * 30;    // 30분
    private final long REFRESH_TOKEN_EXPIRATION = 1000L * 60 * 60 * 24 * 7; // 7일

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION))
                .signWith(key)
                .compact();
    }

    // 3) 토큰에서 username(subject) 추출
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)       // 검증 시 필요한 key 설정
                .build()
                .parseClaimsJws(token)    // JWT 파싱 및 검증
                .getBody()
                .getSubject();            // subject = username
    }

    // 4) 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token); // 문제 없으면 정상 토큰
            return true;
        } catch (Exception e) {
            // 만료, 변조, 서명 오류 등 발생
            return false;
        }
    }
}
