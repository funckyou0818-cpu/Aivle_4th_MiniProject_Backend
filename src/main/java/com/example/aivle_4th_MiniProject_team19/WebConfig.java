package com.example.aivle_4th_MiniProject_team19;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                      // 모든 API 경로
                .allowedOrigins("http://localhost:3000")                // 허용할 출처 (URL)
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT","PATCH", "DELETE") // HTTP 메서드 허용
                .allowedHeaders("*")                                    // 모든 헤더 허용
                .allowCredentials(true);                                // 쿠키 인증 요청 허용
    }
}
