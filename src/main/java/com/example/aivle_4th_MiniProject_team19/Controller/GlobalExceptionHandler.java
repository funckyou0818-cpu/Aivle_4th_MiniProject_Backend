package com.example.aivle_4th_MiniProject_team19.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 400 - 잘못된 요청 (예: 없는 사용자)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<?> handleBadRequest(IllegalArgumentException e) {
        return ApiResponse.of(HttpStatus.BAD_REQUEST, "없거나 삭제된 아이디입니다.");
    }

    // 401 - 인증 실패 (비밀번호 오류, 아이디 중복)
    @ExceptionHandler(SecurityException.class)
    public ApiResponse<?> handleUnauthorized(SecurityException e) {
        return ApiResponse.of(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    // 500 - 서버 내부 오류
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleServerError(Exception e) {
        e.printStackTrace();
        return ApiResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                "서버 내부 오류가 발생했습니다. 관리자에게 문의하세요.");
    }
}
