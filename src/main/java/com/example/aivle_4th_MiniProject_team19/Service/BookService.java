package com.example.aivle_4th_MiniProject_team19.Service;

import com.example.aivle_4th_MiniProject_team19.Controller.dto.BookCreateForm;
import com.example.aivle_4th_MiniProject_team19.Controller.dto.BookUpdateForm;
import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import com.example.aivle_4th_MiniProject_team19.Entity.Member;
import com.example.aivle_4th_MiniProject_team19.Exception.BookNotFoundException;
import com.example.aivle_4th_MiniProject_team19.Repository.BookQueryRepository;
import com.example.aivle_4th_MiniProject_team19.Repository.MemberRepository;
import com.example.aivle_4th_MiniProject_team19.Repository.BookRepository;
import com.example.aivle_4th_MiniProject_team19.Repository.dto.BookSearch;
import com.example.aivle_4th_MiniProject_team19.Service.dto.BookDetailDto;
import com.example.aivle_4th_MiniProject_team19.Service.dto.BookListDto;
import com.example.aivle_4th_MiniProject_team19.Service.dto.MemberDto;
import com.example.aivle_4th_MiniProject_team19.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookQueryRepository bookQueryRepository;
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    // 도서 등록
    @Transactional
    public Long createBook(BookCreateForm bookCreateForm, String authHeder) {
        // 토큰 추출
        String token = authHeder.replace("Bearer ", "");
        // username 꺼내기
        String username = jwtUtil.getUsername(token);
        // Member 조회
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Member not found: " + username));

        Book book = bookCreateForm.toEntity();
        // Member 연결
        book.setMember(member);
        log.info("bookCreateForm.toEntity() : {}, {}, {}", book.getId(), book.getAuthorName(), book.getDescription());
        Book savedBook = bookRepository.save(book);
        log.info("savedBook : {}, {}, {}", savedBook.getId(), savedBook.getAuthorName(), savedBook.getDescription());

        return savedBook.getId();
    }

    // 도서 목록(전체)
    public List<BookListDto> getBookList() {

        List<Book> books = bookRepository.findAll();

        List<BookListDto> list = new ArrayList<>();
        for (Book book : books) {
            BookListDto bookListDto = BookListDto.from(book);
            list.add(bookListDto);
        }

        return list;
    }

    // 도서 검색(목록, 전체)
    public List<BookListDto> searchBookList(String title, String author, String category) {

        BookSearch bookSearch = new BookSearch(title, author, category);
        List<Book> bookList = bookQueryRepository.search(bookSearch);

        List<BookListDto> list = new ArrayList<>();

        for (Book book : bookList) {
            BookListDto bookListDto = BookListDto.from(book);
            list.add(bookListDto);
        }

        return list;
    }

    // 도서 상세(단건)
    public BookDetailDto getBookDetail(Long bookId) {
        return bookRepository.findById(bookId)
                .map(BookDetailDto::from)
                .orElseThrow(() -> new BookNotFoundException("해당 도서를 찾을 수 없습니다. bookId = " + bookId));
    }

    // 도서 수정
    @Transactional
    public Long updateBook(Long bookId, BookUpdateForm bookUpdateForm) {

        // 단건 조회
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("해당 도서를 찾을 수 없습니다. bookId = " + bookId));

        // 수정 (변경 감지)
        book.update(bookUpdateForm.getTitle(), bookUpdateForm.getAuthorName(), bookUpdateForm.getCategory(), bookUpdateForm.getDescription());

        return book.getId();
    }

    // 도서 삭제
    @Transactional
    public Long deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
        return bookId;
    }
}
