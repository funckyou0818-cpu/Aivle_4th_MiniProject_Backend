package com.example.aivle_4th_MiniProject_team19.Controller;

import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import com.example.aivle_4th_MiniProject_team19.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hello")
public class TestController {

    @GetMapping
    private String getBookList() {
        return "테스트 성공";
    }
}
