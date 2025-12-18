package com.example.aivle_4th_MiniProject_team19.Service.dto;

import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailDto {

    private Long bookId;
    private String title;
    private String authorName;
    private String category;
    private String description;
    private MemberDto member;
    private ImageDto image;

    // Entity -> Dto
    public static BookDetailDto from(Book book) {
        return BookDetailDto.builder()
                .bookId(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .category(book.getCategory())
                .description(book.getDescription())
                .member(MemberDto.from(book.getMember()))
                .image(ImageDto.from(book.getImage()))
                .build();
    }
}
