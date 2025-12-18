package com.example.aivle_4th_MiniProject_team19.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Image extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;


    @Column(name = "origin_file_name")
    private String originFileName;

    @Column(name = "modified_file_name")
    private String modifiedFileName;

    @OneToOne(mappedBy = "image")
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }
}
