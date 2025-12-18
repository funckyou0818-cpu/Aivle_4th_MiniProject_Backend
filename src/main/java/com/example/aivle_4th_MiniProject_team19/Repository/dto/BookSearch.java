package com.example.aivle_4th_MiniProject_team19.Repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookSearch {

    private String title;
    private String author;
    private String category;
}
