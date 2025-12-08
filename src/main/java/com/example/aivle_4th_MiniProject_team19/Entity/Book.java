package com.example.aivle_4th_MiniProject_team19.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Book extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;
    private String authorName;
    private String category;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "image_id")
    private Image image;

    // 연관 관계 편의 메서드 (Member)
    public void setMember(Member member) {
        this.member = member;
        member.getBooks().add(this);
    }

    // 연관 관계 편의 메서드 (Image)
    public void setImage(Image image) {
        this.image = image;
        image.setBook(this);
    }

    // 비즈니스 로직
    public void update(String title, String authorName, String category, String description) {
        this.title = title;
        this.authorName = authorName;
        this.category = category;
        this.description = description;
    }
}
