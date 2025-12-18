package com.example.aivle_4th_MiniProject_team19.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String status;
    private String message;
}
