package com.example.aivle_4th_MiniProject_team19.Repository;

import com.example.aivle_4th_MiniProject_team19.Entity.Book;
import com.example.aivle_4th_MiniProject_team19.Repository.dto.BookSearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BookQueryRepository {

    private final EntityManager em;

    public List<Book> search(BookSearch bookSearch) {

        log.info("bookSearch : {}", bookSearch.toString());

        String jpql = "select b from Book b where 1=1";

        if (bookSearch.getTitle() != null && !bookSearch.getTitle().isEmpty()) {
            log.info("bookSearch.getTitle() != null");
            jpql += " and lower(b.title) like lower(:title)";
        }
        if (bookSearch.getAuthor() != null && !bookSearch.getAuthor().isEmpty()) {
            log.info("bookSearch.getAuthor() != null");
            jpql += " and lower(b.authorName) like lower(:author)";
        }
        if (bookSearch.getCategory() != null && !bookSearch.getCategory().isEmpty()) {
            log.info("bookSearch.getCategory() != null");
            jpql += " and lower(b.category) like lower(:category)";
        }

        log.info("jpql : {}", jpql);

        TypedQuery<Book> query = em.createQuery(jpql, Book.class);

        if (bookSearch.getTitle() != null && !bookSearch.getTitle().isEmpty()) {
            query.setParameter("title", "%" + bookSearch.getTitle() + "%");
        }
        if (bookSearch.getAuthor() != null && !bookSearch.getAuthor().isEmpty()) {
            query.setParameter("author", "%" + bookSearch.getAuthor() + "%");
        }
        if (bookSearch.getCategory() != null && !bookSearch.getCategory().isEmpty()) {
            query.setParameter("category", "%" + bookSearch.getCategory() + "%");
        }

        return query.getResultList();
    }

}
