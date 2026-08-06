package com.example.bookmanager.repository;

import com.example.bookmanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT b FROM Book b JOIN FETCH b.authors JOIN FETCH b.categories ORDER BY b.id")
    List<Book> findAllWithAuthorsAndCategories();

    @Query("SELECT DISTINCT b FROM Book b JOIN FETCH b.authors JOIN FETCH b.categories WHERE b.id = :id")
    Optional <Book> findByIdWithAuthorsAndCategories(@Param("id") Long id);
}
