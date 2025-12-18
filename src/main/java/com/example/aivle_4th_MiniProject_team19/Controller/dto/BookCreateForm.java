package com.example.aivle_4th_MiniProject_team19.Controller.dto;

import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCreateForm {

    @NotBlank
    private String title;
    @NotNull
    private String authorName;
    @NotNull
    private String category;
    @NotNull
    private String description;

    public Book toEntity() {
        return Book.builder()
                .title(this.title)
                .authorName(this.authorName)
                .category(this.category)
                .description(this.description)
                .build();
    }
}
