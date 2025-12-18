package com.example.aivle_4th_MiniProject_team19.Service.dto;

import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookListDto {

    private Long bookId;
    private String title;
    private String authorName;
    private String category;

    // Entity -> Dto
    public static BookListDto from(Book book) {
        return BookListDto.builder()
                .bookId(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .category(book.getCategory())
                .build();
    }
}
