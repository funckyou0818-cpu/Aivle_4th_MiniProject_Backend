package com.example.aivle_4th_MiniProject_team19.Controller;

import com.example.aivle_4th_MiniProject_team19.Controller.dto.BookCreateForm;
import com.example.aivle_4th_MiniProject_team19.Controller.dto.BookUpdateForm;
//import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import com.example.aivle_4th_MiniProject_team19.Repository.BookRepository;
import com.example.aivle_4th_MiniProject_team19.Service.BookService;
import com.example.aivle_4th_MiniProject_team19.Service.dto.BookDetailDto;
import com.example.aivle_4th_MiniProject_team19.Service.dto.BookListDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    // 도서 등록
    @PostMapping
    public ApiResponse<Long> createBook(@Valid @RequestBody BookCreateForm bookCreateForm,
                                        @RequestHeader("Authorization") String authHeader) {
        log.info("BookCreateForm : {}", bookCreateForm.toString());

        Long bookId = bookService.createBook(bookCreateForm, authHeader);

        return ApiResponse.of(bookId);
    }

    // 도서 목록
    public ApiResponse<List<BookListDto>> getBookList() {
        log.info("getBookList()");

        List<BookListDto> bookList = bookService.getBookList();

        return ApiResponse.of(bookList);
    }

    // 도서 검색(목록)
    @GetMapping
    public ApiResponse<List<BookListDto>> searchBookList(@RequestParam(required = false) String title,
                                                         @RequestParam(required = false) String author,
                                                         @RequestParam(required = false) String category) {
        log.info("searchBookList()");

        List<BookListDto> bookList = bookService.searchBookList(title, author, category);

        return ApiResponse.of(bookList);
    }

    // 도서 상세
    @GetMapping("/{bookId}")
    public ApiResponse<BookDetailDto> getBookDetail(@PathVariable(name = "bookId") Long bookId) {
        log.info("getBookDetail()");

        BookDetailDto bookDetail = bookService.getBookDetail(bookId);

        return ApiResponse.of(bookDetail);
    }

    // 도서 수정
    @PutMapping("/{bookId}")
    public ApiResponse<Long> updateBook(@PathVariable(name = "bookId") Long bookId,
                                        @RequestBody BookUpdateForm bookUpdateForm,
                                        @RequestHeader("Authorization") String authHeader) {
        log.info("updateBook()");

        Long id = bookService.updateBook(bookId, bookUpdateForm, authHeader);

        return ApiResponse.of(id);
    }

    // 도서 삭제
    @DeleteMapping("/{bookId}")
    public ApiResponse<Long> deleteBook(@PathVariable(name = "bookId") Long bookId,
                                        @RequestHeader("Authorization") String authHeader) {
        log.info("deleteBook()");

        Long id = bookService.deleteBook(bookId, authHeader);

        return ApiResponse.of(id);
    }

}
